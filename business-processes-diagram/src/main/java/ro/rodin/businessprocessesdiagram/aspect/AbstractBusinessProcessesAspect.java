package ro.rodin.businessprocessesdiagram.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;
import ro.rodin.businessprocessesdiagram.diagram.*;

import java.util.LinkedHashMap;

@Aspect
public abstract class AbstractBusinessProcessesAspect {

    @Pointcut
    abstract void process();

    @Around("process()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint, ProceedingJoinPoint.EnclosingStaticPart thisEnclosingJoinPointStaticPart) throws Throwable {
        CodeSignature signature = (CodeSignature) proceedingJoinPoint.getSignature();
        Object[] args = proceedingJoinPoint.getArgs();

        LinkedHashMap<String, Object> input = WorldHelper.getInput(signature.getParameterNames(), args);
        String packageName = signature.getDeclaringType().getPackageName();
        String className = signature.getDeclaringType().getSimpleName();
        String methodName = signature.getName();

        System.out.println("input=" + input);
        System.out.println("packageName =" + packageName);
        System.out.println("className =" + className);
        System.out.println("methodName =" + methodName);
        String callerMethod = thisEnclosingJoinPointStaticPart.getSignature().getName();
        MethodExecution methodExecution = new MethodExecution(className + "_" + methodName, input);
        Diagram diagram = GlobalDiagram.getDiagram();
        TestCase testCase = diagram.addMethodExecutionToTestCase(callerMethod, methodExecution);

        diagram.increaseStackDepth();

        Object output = proceedingJoinPoint.proceed();
        diagram.decreaseStackDepth();

        methodExecution.setOutput(output);

        TestCasePrinter.print(testCase);

        return output;
    }

}