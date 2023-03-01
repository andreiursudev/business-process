package ro.rodin.businessprocessesdiagram.diagram;

import java.util.*;

public class Diagram {

    private List<MethodExecution> methodExecutions;
    private Integer stackDepth = 0;
    private MethodExecution currentMethodExecution;

    public Diagram() {
        methodExecutions = new ArrayList<>();
    }

    public Diagram(MethodExecution methodExecution) {
        this.methodExecutions = List.of(methodExecution);
    }

    public MethodExecution addMethodExecution(MethodExecution methodExecution) {
        if (stackDepth == 0) {
            currentMethodExecution = methodExecution;
            methodExecutions.add(methodExecution);
        } else {
            addMethodExecution(stackDepth, currentMethodExecution, methodExecution);
        }
        return currentMethodExecution;
    }

    private void addMethodExecution(int depth, MethodExecution currentMethodExecution, MethodExecution methodExecution) {
        if (depth == 1) {
            currentMethodExecution.getChildren().add(methodExecution);
        } else {
            MethodExecution lastChild = currentMethodExecution.getChildren().get(currentMethodExecution.getChildren().size() - 1);
            addMethodExecution(depth - 1, lastChild, methodExecution);
        }
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

    public List<MethodExecution> getMethodExecutions() {
        return methodExecutions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Diagram diagram = (Diagram) o;
        return Objects.equals(methodExecutions, diagram.methodExecutions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(methodExecutions);
    }

    @Override
    public String toString() {
        return "Diagram{" +
                "methodExecutions=" + methodExecutions +
                '}';
    }

    public void clear() {
        this.methodExecutions.clear();
    }
}


