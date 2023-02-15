package ro.rodin.businessprocessesdiagram.diagram;

import java.util.*;

public class Diagram {

    public List<TestCase> testCases;
    private Integer stackDepth = 0;
    private TestCase currentTestCase;

    public Diagram() {
        testCases = new ArrayList<>();
    }

    public TestCase addMethodExecutionToTestCase(String testCaseName, MethodExecution methodExecution) {
        if (stackDepth == 0) {
            currentTestCase = new TestCase(testCaseName, methodExecution);
            testCases.add(currentTestCase);
        } else {
            MethodExecution currentMethodExecution = currentTestCase.getMethodExecution();
            for (int i = 1; i < stackDepth; i++) {
                currentMethodExecution = currentMethodExecution.getChildren().get(currentMethodExecution.getChildren().size() - 1);
            }
            currentMethodExecution.getChildren().add(methodExecution);
        }
        return currentTestCase;
    }

    public void increaseStackDepth() {
        stackDepth++;
    }

    public void decreaseStackDepth() {
        stackDepth--;
    }

    public Integer getStackDepth() {
        return stackDepth;
    }

    public List<TestCase> getTestCases() {
        return testCases;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Diagram diagram = (Diagram) o;
        return Objects.equals(testCases, diagram.testCases);
    }

    @Override
    public int hashCode() {
        return Objects.hash(testCases);
    }

    @Override
    public String toString() {
        return "Diagram{" +
                "methodExecutionToTestCase=" + testCases +
                '}';
    }
}


