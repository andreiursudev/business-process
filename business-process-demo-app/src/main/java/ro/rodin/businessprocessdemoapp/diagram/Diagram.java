package ro.rodin.businessprocessdemoapp.diagram;

import java.util.*;

public class Diagram {

    public LinkedHashMap<TestCase, List<MethodExecution>> methodExecutionsToTestCase;

    public Diagram(LinkedHashMap<TestCase, List<MethodExecution>> methodExecutionsToTestCase) {
        this.methodExecutionsToTestCase = methodExecutionsToTestCase;
    }

    public Diagram() {
        methodExecutionsToTestCase = new LinkedHashMap<>();
    }

    public void addMethodExecutionToTestCase(String testCaseName, MethodExecution methodExecution) {
        Thread thread = Thread.currentThread();
        TestCase testCase = new TestCase(thread.getName(), testCaseName);

        if (!methodExecutionsToTestCase.containsKey(testCase)) {
            String name = UUID.randomUUID().toString();
            thread.setName(name);
            testCase.setId(name);
            methodExecutionsToTestCase.put(testCase, new ArrayList<>());
        }
        methodExecutionsToTestCase.get(testCase).add(methodExecution);
    }

    public void clean() {
        methodExecutionsToTestCase.clear();
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


