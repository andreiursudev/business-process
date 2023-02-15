package ro.rodin.businessprocessesdiagram.diagram;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TestCasePrinter {

    private static Integer numberOfTestCases = 0;

    public static void print(TestCase testCase) {

        ObjectMapper objectMapper = new ObjectMapper();
        if (GlobalDiagram.getDiagram().getStackDepth() == 0) {
            try {
                FileWriter fw = new FileWriter("testCases.js", true);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write("var testCase" + numberOfTestCases++ + " = " +objectMapper.writeValueAsString(testCase));
                bw.newLine();
                bw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
