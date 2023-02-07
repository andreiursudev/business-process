package ro.rodin.businessprocessdemoapp.aspect;

import org.aspectj.lang.reflect.CodeSignature;

import java.util.LinkedHashMap;

public class WorldHelper {
    public static LinkedHashMap<String, Object> getInput(CodeSignature signature, Object[] args) {
        LinkedHashMap<String, Object> input = new LinkedHashMap<>();
        String[] parameterNames = signature.getParameterNames();
        for (int i = 0; i < parameterNames.length; i++) {
            input.put(parameterNames[i], args[i]);
        }
        return input;
    }
}
