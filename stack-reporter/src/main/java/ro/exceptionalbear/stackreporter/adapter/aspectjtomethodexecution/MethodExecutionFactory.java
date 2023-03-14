package ro.exceptionalbear.stackreporter.adapter.aspectjtomethodexecution;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.CodeSignature;
import ro.exceptionalbear.stackreporter.methodexecution.MethodExecution;

public class MethodExecutionFactory {

    public MethodExecution getMethodExecution(ProceedingJoinPoint proceedingJoinPoint) {
        CodeSignature codeSignature = (CodeSignature) proceedingJoinPoint.getSignature();
        Object[] args = proceedingJoinPoint.getArgs();
        String input = InputFactory.getInput(codeSignature.getParameterNames(), args);
        String packageName = codeSignature.getDeclaringType().getPackageName();
        String className = codeSignature.getDeclaringType().getSimpleName();
        String methodName = codeSignature.getName();

        if (packageName.equals("jdk.proxy2")) {
            packageName = proceedingJoinPoint.getTarget().getClass().getInterfaces()[0].getPackageName();
            className = proceedingJoinPoint.getTarget().getClass().getInterfaces()[0].getSimpleName();
        }
        return new MethodExecution(packageName, className, methodName, input);
    }

    public MethodExecution getMethodExecution(JoinPoint.EnclosingStaticPart thisEnclosingJoinPointStaticPart) {
        CodeSignature enclosingSignature = (CodeSignature) thisEnclosingJoinPointStaticPart.getSignature();
        return new MethodExecution(enclosingSignature.getDeclaringType().getPackageName(), enclosingSignature.getDeclaringType().getSimpleName(), enclosingSignature.getName(), "");
    }
}
