package ro.exceptionalbear.stackreporter.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import ro.exceptionalbear.stackreporter.methodexecution.MethodExecutionBuilder;
import ro.exceptionalbear.stackreporter.methodexecution.RootIdToMethodExecution;
import ro.exceptionalbear.stackreporter.methodexecution.MethodExecution;
import ro.exceptionalbear.stackreporter.adapter.aspectjtomethodexecution.MethodExecutionFactory;

@Aspect
public abstract class MethodCallAspect {

    private MethodExecutionFactory methodExecutionFactory = new MethodExecutionFactory();

    @Pointcut()
    abstract void methodCall();

    @Around("methodCall()")
    public Object startBuildingMethodExecution(ProceedingJoinPoint proceedingJoinPoint, ProceedingJoinPoint.EnclosingStaticPart thisEnclosingJoinPointStaticPart) throws Throwable {
        MethodExecution currentMethodExecution = methodExecutionFactory.getMethodExecution(proceedingJoinPoint);
        MethodExecution currentMethodExecutionTree = MethodExecutionBuilder.INSTANCE.addMethodExecution(currentMethodExecution);

        MethodExecutionBuilder.INSTANCE.increaseTreeDepth();

        Object output = proceedingJoinPoint.proceed();
        currentMethodExecution.setOutput(output);

        MethodExecutionBuilder.INSTANCE.decreaseTreeDepth();

        if (MethodExecutionBuilder.INSTANCE.isRootDepth()) {
            MethodExecution rootMethodExecution = methodExecutionFactory.getMethodExecution(thisEnclosingJoinPointStaticPart);
            RootIdToMethodExecution.addMethodExecutionTreeToRootMethodExecution(currentMethodExecutionTree, rootMethodExecution);
        }

        return output;
    }




}