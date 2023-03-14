package ro.exceptionalbear.stackreporter.adapter.aspectjtomethodexecution;

import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;

public class OutputFactory {


    public static String getOutputValue(Signature codeSignature, Object output) {
        String outputValue;
        if (((MethodSignature) codeSignature).getReturnType().getSimpleName().equals("void")) {
            outputValue = "";
        } else {
            outputValue = getOutput(output);
        }
        return outputValue;
    }

    private static String getOutput(Object output) {
        return output.toString();
    }
}
