package ro.rodin.businessprocessesdiagram.diagram;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MethodExecution {

    private String methodName;
    private String input;
    private String output;
    private List<MethodExecution> children = new ArrayList<>();

    public MethodExecution(String methodName, String input) {
        this.methodName = methodName;
        this.input = input;
    }

    public MethodExecution(String methodName, String input, String output) {
        this.methodName = methodName;
        this.input = input;
        this.output = output;
    }

    public MethodExecution(String methodName, String input, String output, List<MethodExecution> children) {
        this.methodName = methodName;
        this.input = input;
        this.output = output;
        this.children = children;
    }

    public MethodExecution(String methodName, MethodExecution child) {
        this.methodName = methodName;
        this.input = null;
        this.output = null;
        this.children = List.of(child);
    }

    public String getMethodName() {
        return methodName;
    }

    public String getInput() {
        return input;
    }


    public Object getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public List<MethodExecution> getChildren() {
        return children;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MethodExecution that = (MethodExecution) o;
        return Objects.equals(methodName, that.methodName) && Objects.equals(input, that.input) && Objects.equals(output, that.output) && Objects.equals(children, that.children);
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
}
