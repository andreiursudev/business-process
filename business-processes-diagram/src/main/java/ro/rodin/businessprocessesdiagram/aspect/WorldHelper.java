package ro.rodin.businessprocessesdiagram.aspect;

import com.fasterxml.jackson.core.JsonProcessingException;
import ro.rodin.businessprocessesdiagram.diagram.CustomObjectMapper;

import java.util.LinkedHashMap;

public class WorldHelper {
    public static String getInput(String[] parameterNames, Object[] args) {
        if(parameterNames.length == 0){
            return null;
        }
        LinkedHashMap<String, Object> input = new LinkedHashMap<>();
        for (int i = 0; i < parameterNames.length; i++) {
            input.put(parameterNames[i], args[i]);
        }
        try {
            return CustomObjectMapper.INSTANCE.getObjectMapper().writeValueAsString(input);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getOutput(Object output) {
        try {
            return CustomObjectMapper.INSTANCE.getObjectMapper().writeValueAsString(output);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
