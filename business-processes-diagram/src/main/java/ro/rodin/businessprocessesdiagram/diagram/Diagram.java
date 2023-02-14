package ro.rodin.businessprocessesdiagram.diagram;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;

public class Diagram {

    public LinkedHashMap<TestCase, List<MethodExecution>> methodExecutionsToTestCase;
    private Integer stackDepth = 0;
    private TestCase currentTestCase;

    public Diagram() {
        methodExecutionsToTestCase = new LinkedHashMap<>();
    }

    public void addMethodExecutionToTestCase(String testCaseName, MethodExecution methodExecution) {
        if (stackDepth == 0) {
            currentTestCase = new TestCase(testCaseName);
            methodExecutionsToTestCase.put(currentTestCase, new ArrayList<>());
            methodExecutionsToTestCase.get(currentTestCase).add(methodExecution);
        } else {
            List<MethodExecution> methodExecutions = methodExecutionsToTestCase.get(currentTestCase);
            MethodExecution currentMethodExecution = methodExecutions.get(methodExecutions.size() - 1);
            for (int i = 1; i < stackDepth; i++) {
                currentMethodExecution = currentMethodExecution.getChildren().get(currentMethodExecution.getChildren().size() - 1);
            }
            currentMethodExecution.getChildren().add(methodExecution);
        }
    }

    public void increaseStackDepth() {
        stackDepth++;
    }

    public void decreaseStackDepth() {
        stackDepth--;
    }

    public LinkedHashMap<TestCase, List<MethodExecution>> getMethodExecutionsToTestCase() {
        return methodExecutionsToTestCase;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Diagram diagram = (Diagram) o;
        return Objects.equals(methodExecutionsToTestCase, diagram.methodExecutionsToTestCase);
    }

    @Override
    public int hashCode() {
        return Objects.hash(methodExecutionsToTestCase);
    }

    @Override
    public String toString() {
        return "Diagram{" +
                "methodExecutionToTestCase=" + methodExecutionsToTestCase +
                '}';
    }
}


