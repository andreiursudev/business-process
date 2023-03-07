package ro.rodin.businessprocessesdiagram.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;
import org.aspectj.lang.reflect.MethodSignature;
import ro.rodin.businessprocessesdiagram.diagram.Diagram;
import ro.rodin.businessprocessesdiagram.diagram.GlobalDiagram;
import ro.rodin.businessprocessesdiagram.diagram.MethodExecution;
import ro.rodin.businessprocessesdiagram.diagram.MethodExecutionPrinter;

@Aspect
public abstract class AbstractBusinessProcessesAspect {

    @Pointcut()
    abstract void process();

    @Around("process()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        CodeSignature codeSignature = (CodeSignature) proceedingJoinPoint.getSignature();
        Object[] args = proceedingJoinPoint.getArgs();
        String input = WorldHelper.getInput(codeSignature.getParameterNames(), args);
        String packageName = codeSignature.getDeclaringType().getPackageName();
        String className = codeSignature.getDeclaringType().getSimpleName();
        String methodName = codeSignature.getName();

        //System.out.println("input=" + input);
        //System.out.println("packageName =" + packageName);
        //System.out.println("className =" + className);
        //System.out.println("methodName =" + methodName);
        if(packageName.equals("jdk.proxy2")){
            packageName = proceedingJoinPoint.getTarget().getClass().getInterfaces()[0].getPackageName();
            className = proceedingJoinPoint.getTarget().getClass().getInterfaces()[0].getSimpleName();
        }
        MethodExecution methodExecution = new MethodExecution(packageName, className, methodName, input);
        Diagram diagram = GlobalDiagram.getDiagram();
        MethodExecution methodExecutionResult = diagram.addMethodExecution(methodExecution);

        diagram.increaseStackDepth();

        Object output = proceedingJoinPoint.proceed();
        MethodSignature methodSignature = (MethodSignature) codeSignature;
        diagram.decreaseStackDepth();

        if(methodSignature.getReturnType().getSimpleName().equals("void")){
        methodExecution.setOutput("");
        } else {
            methodExecution.setOutput(WorldHelper.getOutput(output));
        }

        if (GlobalDiagram.getDiagram().getStackDepth() == 0) {
            MethodExecutionPrinter.print(methodExecutionResult);
            GlobalDiagram.getDiagram().clear();
        }

        return output;
    }

}