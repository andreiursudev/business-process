package ro.rodin.businessprocessdemoapp;

import org.aspectj.lang.reflect.CodeSignature;

import java.util.LinkedHashMap;

public aspect World {
    pointcut wrapAll() : execution(* ro.rodin.businessprocessdemoapp.NameToJson.toJson(..));
    //pointcut wrapAll() : execution(* *(..));

    before() : wrapAll(){
        CodeSignature signature = (CodeSignature) thisJoinPointStaticPart.getSignature();
        String[] parameterNames = signature.getParameterNames();
        Object[] args = thisJoinPoint.getArgs();
        LinkedHashMap<Object, Object> input = new LinkedHashMap<>();
        for(int i=0; i < parameterNames.length; i++){
            input.put(parameterNames[i], args[i]);
        }
        System.out.println("input=" + input);
        System.out.println("package=" + signature.getDeclaringType().getPackageName());
        System.out.println("object=" + signature.getDeclaringType().getSimpleName());
        System.out.println("method=" + signature.getName());
    }

    after() returning(Object output) : wrapAll(){
        System.out.println("output =" + output);
    }
}