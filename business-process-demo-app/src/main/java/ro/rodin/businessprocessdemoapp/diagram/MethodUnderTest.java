package ro.rodin.businessprocessdemoapp.diagram;

import java.util.Objects;

public class MethodUnderTest {
    private String methodName;

    public MethodUnderTest(String methodName) {
        this.methodName = methodName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MethodUnderTest that = (MethodUnderTest) o;
        return Objects.equals(methodName, that.methodName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(methodName);
    }

    @Override
    public String toString() {
        return "MethodUnderTest{" +
                "methodName='" + methodName + '\'' +
                '}';
    }
}
