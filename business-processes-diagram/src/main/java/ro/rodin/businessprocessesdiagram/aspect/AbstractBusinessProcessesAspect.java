package ro.rodin.businessprocessesdiagram.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;
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
        CodeSignature signature = (CodeSignature) proceedingJoinPoint.getSignature();
        Object[] args = proceedingJoinPoint.getArgs();

        String input = WorldHelper.getInput(signature.getParameterNames(), args);
        String packageName = signature.getDeclaringType().getPackageName();
        String className = signature.getDeclaringType().getSimpleName();
        String methodName = signature.getName();

        //System.out.println("input=" + input);
        //System.out.println("packageName =" + packageName);
        //System.out.println("className =" + className);
        //System.out.println("methodName =" + methodName);
        MethodExecution methodExecution = new MethodExecution(packageName, className, methodName, input);
        Diagram diagram = GlobalDiagram.getDiagram();
        MethodExecution methodExecutionResult = diagram.addMethodExecution(methodExecution);

        diagram.increaseStackDepth();

        Object output = proceedingJoinPoint.proceed();
        diagram.decreaseStackDepth();

        methodExecution.setOutput(WorldHelper.getOutput(output));

        if (GlobalDiagram.getDiagram().getStackDepth() == 0) {
            MethodExecutionPrinter.print(methodExecutionResult);
            GlobalDiagram.getDiagram().clear();
        }

        return output;
    }

}