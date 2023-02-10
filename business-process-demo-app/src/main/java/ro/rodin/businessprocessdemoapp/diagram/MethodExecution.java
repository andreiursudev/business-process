package ro.rodin.businessprocessdemoapp.diagram;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;

public class MethodExecution {

    private String methodName;
    private LinkedHashMap<String, Object> input;
    private Object output;
    private List<MethodExecution> children = new ArrayList<>();

    public MethodExecution(String methodName, LinkedHashMap<String, Object> input) {
        this.methodName = methodName;
        this.input = input;
    }

    public MethodExecution(String methodName, LinkedHashMap<String, Object> input, Object output) {
        this.methodName = methodName;
        this.input = input;
        this.output = output;
    }

    public MethodExecution(String methodName, LinkedHashMap<String, Object> input, Object output, List<MethodExecution> children) {
        this.methodName = methodName;
        this.input = input;
        this.output = output;
        this.children = children;
    }


    public void setOutput(Object output) {
        this.output = output;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MethodExecution that = (MethodExecution) o;
        return Objects.equals(methodName, that.methodName) && Objects.equals(input, that.input) && Objects.equals(output, that.output) && Objects.equals(children, that.children);
    }

    @Override
    public int hashCode() {
        return Objects.hash(methodName, input, output, children);
    }

    @Override
    public String toString() {
        return "MethodExecution{" +
                "methodName='" + methodName + '\'' +
                ", input=" + input +
                ", output=" + output +
                ", children=" + children +
                '}';
    }

    public List<MethodExecution> getChildren() {
        return children;
    }
}
