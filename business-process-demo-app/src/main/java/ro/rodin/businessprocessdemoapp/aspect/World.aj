package ro.rodin.businessprocessdemoapp.aspect;

import org.aspectj.lang.reflect.CodeSignature;
import ro.rodin.businessprocessdemoapp.diagram.Diagram;
import ro.rodin.businessprocessdemoapp.diagram.Element;

import java.util.LinkedHashMap;

public aspect World {
    //pointcut wrapAll(): execution(* ro.rodin.businessprocessdemoapp.logic.NameToJson.toJson(..));
    pointcut wrapAll(): execution(* ro.rodin.businessprocessdemoapp.logic..*(..));
    //pointcut wrapAll() : execution(* *(..));

    Object around(): wrapAll(){
        CodeSignature signature = (CodeSignature) thisJoinPointStaticPart.getSignature();
        String[] parameterNames = signature.getParameterNames();
        Object[] args = thisJoinPoint.getArgs();
        LinkedHashMap<String, Object> input = new LinkedHashMap<>();
        for (int i = 0; i < parameterNames.length; i++) {
            input.put(parameterNames[i], args[i]);
        }
        String packageName = signature.getDeclaringType().getPackageName();
        String className = signature.getDeclaringType().getSimpleName();
        String methodName = signature.getName();
        Object output = proceed();
        Element element = new Element(input, packageName, className, methodName, output);

        Diagram.addElement(element);
        return output;
    }

}