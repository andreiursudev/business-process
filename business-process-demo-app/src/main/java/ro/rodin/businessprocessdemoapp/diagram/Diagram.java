package ro.rodin.businessprocessdemoapp.diagram;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Diagram {

    public static Map<String, List<MethodExecution>> methodExecutionToTestCase = new HashMap<>();


    public static List<MethodExecution> getMethodExecutionByTestCase(String testCase) {
        return methodExecutionToTestCase.get(testCase);
    }

}


