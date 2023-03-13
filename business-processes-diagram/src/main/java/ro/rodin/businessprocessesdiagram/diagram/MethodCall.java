package ro.rodin.businessprocessesdiagram.diagram;
import java.util.List;

public class MethodCall {

    private MethodExecution methodCall;
    private List<MethodExecution> methodExecutions;


    public MethodCall(MethodExecution methodCall, List<MethodExecution> methodExecutions) {
        this.methodCall = methodCall;
        this.methodExecutions = methodExecutions;
    }

    public MethodExecution getMethodCall() {
        return methodCall;
    }

    public List<MethodExecution> getMethodExecutions() {
        return methodExecutions;
    }

    @Override
    public String toString() {
        return "TestCase{" +
                "testCase=" + methodCall +
                ", methodExecutions=" + methodExecutions +
                '}';
    }
}
