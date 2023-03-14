package ro.exceptionalbear.stackreporter.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import ro.exceptionalbear.stackreporter.methodexecution.MethodExecution;
import ro.exceptionalbear.stackreporter.adapter.methodexecutiontofile.MethodExecutionPrinter;
import ro.exceptionalbear.stackreporter.methodexecution.MethodExecutionBuilder;
import ro.exceptionalbear.stackreporter.methodexecution.RootIdToMethodExecution;
import ro.exceptionalbear.stackreporter.adapter.aspectjtomethodexecution.MethodExecutionFactory;
import ro.exceptionalbear.stackreporter.adapter.aspectjtomethodexecution.OutputFactory;

@Aspect
public abstract class MethodExecutionAspect {

    private MethodExecutionFactory methodExecutionFactory = new MethodExecutionFactory();

    @Pointcut()
    abstract void methodExecution();

    @Around("methodExecution()")
    public Object closeBuildingMethodExecution(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodExecution currentMethodExecution = methodExecutionFactory.getMethodExecution(proceedingJoinPoint);

        Object output = proceedingJoinPoint.proceed();

        MethodExecution rootMethodExecution = RootIdToMethodExecution.getMethodExecutionByRootId(currentMethodExecution.getId());
        if (rootMethodExecution != null) {
            rootMethodExecution.setInput(currentMethodExecution.getInput());
            rootMethodExecution.setOutput(OutputFactory.getOutputValue(proceedingJoinPoint.getSignature(), output));
            MethodExecutionPrinter.print(rootMethodExecution);
            RootIdToMethodExecution.clear();
            MethodExecutionBuilder.INSTANCE.clear();
        }

        return output;
    }

}