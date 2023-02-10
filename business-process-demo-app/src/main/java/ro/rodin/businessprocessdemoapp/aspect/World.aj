package ro.rodin.businessprocessdemoapp.aspect;

import org.aspectj.lang.reflect.CodeSignature;
import ro.rodin.businessprocessdemoapp.diagram.*;

import java.util.LinkedHashMap;

public aspect World {
    //pointcut wrapAll(): execution(* ro.rodin.businessprocessdemoapp.logic.NameToJson.toJson(..));
    //pointcut wrapExecutionAll(): execution(* ro.rodin.businessprocessdemoapp.logic..*(..));
    pointcut wrapCallAll(): call(* ro.rodin.businessprocessdemoapp.logic..*(..));
    //pointcut wrapAll() : execution(* *(..));

    /*before() : wrapExecutionAll(){
        CodeSignature signature = (CodeSignature) thisJoinPointStaticPart.getSignature();
        Object[] args = thisJoinPoint.getArgs();
        String callerSignature = thisEnclosingJoinPointStaticPart.getSignature().getName();
        System.out.println("before wrapExecutionAll=" + callerSignature);
    }*/

    Object around(): wrapCallAll(){
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
        diagram.addMethodExecutionToTestCase(callerMethod, methodExecution);

        diagram.increaseStackDepth();

        Object output = proceed();
        diagram.decreaseStackDepth();

        methodExecution.setOutput(output);

        return output;
    }

    /*before() : wrapCallAll(){
        CodeSignature signature = (CodeSignature) thisJoinPointStaticPart.getSignature();
        Object[] args = thisJoinPoint.getArgs();
        String callerSignature = thisEnclosingJoinPointStaticPart.getSignature().getName();
        System.out.println("before wrapCallAll=" + callerSignature);
    }*/

}