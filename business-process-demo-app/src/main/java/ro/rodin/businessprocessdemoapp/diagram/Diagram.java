package ro.rodin.businessprocessdemoapp.diagram;

import java.util.*;

public class Diagram {

    public LinkedHashMap<TestCase, List<MethodExecution>> methodExecutionsToTestCase;
    private Integer stackDepth = 0;
    private TestCase currentTestCase;

    public Diagram() {
        methodExecutionsToTestCase = new LinkedHashMap<>();
    }

    public void addMethodExecutionToTestCase(String testCaseName, MethodExecution methodExecution) {
        if(stackDepth == 0) {
            currentTestCase = new TestCase(testCaseName);
            methodExecutionsToTestCase.put(currentTestCase, new ArrayList<>());
        }
        methodExecutionsToTestCase.get(currentTestCase).add(methodExecution);
    }

    public void increaseStackDepth(){
        stackDepth++;
    }

    public void decreaseStackDepth(){
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


