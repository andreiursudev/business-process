package ro.rodin.businessprocessesdiagram.diagram;

import java.util.Objects;

public class TestCase {
    private String testCaseName;

    public TestCase(String testCaseName) {
        this.testCaseName = testCaseName;
    }

    public String getTestCaseName() {
        return testCaseName;
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
                '}';
    }
}
