package ro.rodin.businessprocessesdiagram.diagram;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class MethodExecutionPrinter {

    private static Integer numberOfMethodExecutions = 0;

    public static void print(MethodExecution methodExecution) {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        try {
            FileWriter fw = new FileWriter("methodExecutions.js", true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("var methodExecution" + ++numberOfMethodExecutions + " = " + objectMapper.writeValueAsString(methodExecution));
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
