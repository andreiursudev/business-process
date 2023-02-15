package ro.rodin.businessprocessesdiagram.diagram;

import java.util.Objects;

public class TestCase {
    private String testCaseName;
    private MethodExecution methodExecution;

    public TestCase(String testCaseName, MethodExecution methodExecution) {
        this.testCaseName = testCaseName;
        this.methodExecution = methodExecution;
    }

    public String getTestCaseName() {
        return testCaseName;
    }

    public MethodExecution getMethodExecution() {
        return methodExecution;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestCase testCase = (TestCase) o;
        return Objects.equals(testCaseName, testCase.testCaseName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(testCaseName);
    }

    @Override
    public String toString() {
        return "TestCase{" +
                "testCaseName='" + testCaseName + '\'' +
                ", methodExecution=" + methodExecution +
                '}';
    }
}
