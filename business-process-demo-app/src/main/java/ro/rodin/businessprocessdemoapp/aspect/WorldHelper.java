package ro.rodin.businessprocessdemoapp.aspect;

import java.util.LinkedHashMap;

public class WorldHelper {
    public static LinkedHashMap<String, Object> getInput(String[] parameterNames, Object[] args) {
        LinkedHashMap<String, Object> input = new LinkedHashMap<>();
        for (int i = 0; i < parameterNames.length; i++) {
            input.put(parameterNames[i], args[i]);
        }
        return input;
    }
}
