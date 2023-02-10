package ro.rodin.businessprocessdemoapp.diagram;

import java.util.LinkedHashMap;
import java.util.Objects;

public class MethodExecution {

    private String methodName;
    private LinkedHashMap<String, Object> input;
    private Object output;

    public MethodExecution(String methodName, LinkedHashMap<String, Object> input) {
        this.methodName = methodName;
        this.input = input;
    }

    public MethodExecution(String methodName, LinkedHashMap<String, Object> input, Object output) {
        this.methodName = methodName;
        this.input = input;
        this.output = output;
    }


    public void setOutput(Object output) {
        this.output = output;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MethodExecution that = (MethodExecution) o;
        return Objects.equals(methodName, that.methodName) && Objects.equals(input, that.input) && Objects.equals(output, that.output);
    }

    @Override
    public int hashCode() {
        return Objects.hash(methodName, input, output);
    }

    @Override
    public String toString() {
        return "MethodExecution2{" +
                "methodName='" + methodName + '\'' +
                ", input=" + input +
                ", output=" + output +
                '}';
    }
}
