package ro.rodin.businessprocessesdiagram.aspect;

import org.aspectj.lang.reflect.CodeSignature;
import ro.rodin.businessprocessesdiagram.diagram.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public abstract aspect AbstractBusinessProcessesAspect {
    abstract pointcut process();

    Object around(): process(){
        CodeSignature signature = (CodeSignature) thisJoinPointStaticPart.getSignature();
        Object[] args = thisJoinPoint.getArgs();

        LinkedHashMap<String, Object> input = WorldHelper.getInput(signature.getParameterNames(), args);
        String packageName = signature.getDeclaringType().getPackageName();
        String className = signature.getDeclaringType().getSimpleName();
        String methodName = signature.getName();

        System.out.println("input=" + input);
        System.out.println("packageName =" + packageName);
        System.out.println("className =" + className);
        System.out.println("methodName =" + methodName);
        String callerMethod = thisEnclosingJoinPointStaticPart.getSignature().getName();
        MethodExecution methodExecution = new MethodExecution(methodName, input);
        Diagram diagram = GlobalDiagram.getDiagram();
        Map<TestCase, List<MethodExecution>> testCase = diagram.addMethodExecutionToTestCase(callerMethod, methodExecution);

        diagram.increaseStackDepth();

        Object output = proceed();
        diagram.decreaseStackDepth();

        methodExecution.setOutput(output);

        if(GlobalDiagram.getDiagram().getStackDepth() == 0) {
            try {
                FileWriter fw = new FileWriter("diagram.txt", true);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(testCase.toString());
                bw.newLine();
                bw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return output;
    }

}