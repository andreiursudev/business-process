package ro.rodin.businessprocessdemoapp.aspect;

import org.aspectj.lang.reflect.CodeSignature;
import ro.rodin.businessprocessdemoapp.diagram.Diagram;
import ro.rodin.businessprocessdemoapp.diagram.Element;

public aspect World {
    //pointcut wrapAll(): execution(* ro.rodin.businessprocessdemoapp.logic.NameToJson.toJson(..));
    pointcut wrapAll(): execution(* ro.rodin.businessprocessdemoapp.logic..*(..));
    //pointcut wrapAll() : execution(* *(..));

    Object around(): wrapAll(){
        var signature = (CodeSignature) thisJoinPointStaticPart.getSignature();
        var args = thisJoinPoint.getArgs();

        var input = WorldHelper.getInput(signature, args);
        var packageName = signature.getDeclaringType().getPackageName();
        var className = signature.getDeclaringType().getSimpleName();
        var methodName = signature.getName();

        var output = proceed();

        Diagram.addElement(new Element(input, packageName, className, methodName, output));

        return output;
    }

}