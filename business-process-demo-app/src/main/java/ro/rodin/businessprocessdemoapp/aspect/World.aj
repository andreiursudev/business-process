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
        Object[] args = thisJoinPoint.getArgs();

        LinkedHashMap<String, Object> input = WorldHelper.getInput(signature, args);
        String packageName = signature.getDeclaringType().getPackageName();
        String className = signature.getDeclaringType().getSimpleName();
        String methodName = signature.getName();

        Object output = proceed();

        Diagram.addElement(new Element(input, packageName, className, methodName, output));

        return output;
    }

}