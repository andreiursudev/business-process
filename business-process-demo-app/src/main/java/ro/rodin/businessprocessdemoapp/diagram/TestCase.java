package ro.rodin.businessprocessdemoapp.diagram;

import java.util.Objects;

public class TestCase {
    private String id;
    private String testCaseName;

    public TestCase(String id, String testCaseName) {
        this.id = id;
        this.testCaseName = testCaseName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTestCaseName() {
        return testCaseName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestCase testCase = (TestCase) o;
        return Objects.equals(id, testCase.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "TestCase{" +
                "id='" + id + '\'' +
                ", testCaseName='" + testCaseName + '\'' +
                '}';
    }
}
