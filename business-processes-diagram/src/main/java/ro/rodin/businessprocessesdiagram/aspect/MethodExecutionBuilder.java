package ro.rodin.businessprocessesdiagram.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;
import org.aspectj.lang.reflect.MethodSignature;
import ro.rodin.businessprocessesdiagram.diagram.*;

import java.util.ArrayList;
import java.util.List;

@Aspect
public abstract class MethodExecutionBuilder {

    @Pointcut()
    abstract void callMethodFromPackage();

    @Around("callMethodFromPackage()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint, ProceedingJoinPoint.EnclosingStaticPart thisEnclosingJoinPointStaticPart) throws Throwable {
        CodeSignature codeSignature = (CodeSignature) proceedingJoinPoint.getSignature();
        Object[] args = proceedingJoinPoint.getArgs();
        String input = WorldHelper.getInput(codeSignature.getParameterNames(), args);
        String packageName = codeSignature.getDeclaringType().getPackageName();
        String className = codeSignature.getDeclaringType().getSimpleName();
        String methodName = codeSignature.getName();

        if (packageName.equals("jdk.proxy2")) {
            packageName = proceedingJoinPoint.getTarget().getClass().getInterfaces()[0].getPackageName();
            className = proceedingJoinPoint.getTarget().getClass().getInterfaces()[0].getSimpleName();
        }
        MethodExecution methodExecution = new MethodExecution(packageName, className, methodName, input);
        Diagram diagram = GlobalDiagram.getDiagram();
        MethodExecution methodExecutionResult = diagram.addMethodExecution(methodExecution);

        diagram.increaseStackDepth();

        CodeSignature enclosingSignature = (CodeSignature) thisEnclosingJoinPointStaticPart.getSignature();
        String id = enclosingSignature.getDeclaringType().getPackageName() +
                enclosingSignature.getDeclaringType().getSimpleName() +
                enclosingSignature.getName();

        Object output = proceedingJoinPoint.proceed();
        MethodSignature methodSignature = (MethodSignature) codeSignature;
        diagram.decreaseStackDepth();

        if (methodSignature.getReturnType().getSimpleName().equals("void")) {
            methodExecution.setOutput("");
        } else {
            methodExecution.setOutput(WorldHelper.getOutput(output));
        }

        if (GlobalDiagram.getDiagram().getStackDepth() == 0) {
            CallMap.getMap().computeIfAbsent(id, k -> new MethodExecution(enclosingSignature.getDeclaringType().getPackageName(),enclosingSignature.getDeclaringType().getSimpleName(),enclosingSignature.getName(), ""));
            List<MethodExecution> methodExecutions = CallMap.getMap().get(id).getChildren();
            methodExecutions.add(methodExecutionResult);

            GlobalDiagram.getDiagram().clear();
        }

        return output;
    }

}