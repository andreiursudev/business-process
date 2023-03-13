package ro.rodin.businessprocessesdiagram.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;
import ro.rodin.businessprocessesdiagram.diagram.*;

@Aspect
public abstract class MethodExecutionLogger {

    @Pointcut()
    abstract void executeMethodFromPackage();

    @Around("executeMethodFromPackage()")
    public Object logMethodExecution(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        CodeSignature codeSignature = (CodeSignature) proceedingJoinPoint.getSignature();
        Object[] args = proceedingJoinPoint.getArgs();
        String input = WorldHelper.getInput(codeSignature.getParameterNames(), args);
        String packageName = codeSignature.getDeclaringType().getPackageName();
        String className = codeSignature.getDeclaringType().getSimpleName();
        String methodName = codeSignature.getName();

        Object output = proceedingJoinPoint.proceed();

        MethodCall methodCall = CallMap.getMap().get(packageName + className + methodName);
        if (methodCall != null) {
            methodCall.getMethodCall().setInput(input);
            methodCall.getMethodCall().setOutput(WorldHelper.getOutput(output));
            MethodExecutionPrinter.print(new MethodExecution(methodCall.getMethodCall(), methodCall.getMethodExecutions()));
        }

        return output;
    }

}