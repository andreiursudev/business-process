package ro.rodin.businessprocessdemoapp.diagram;

import org.junit.jupiter.api.Test;
import ro.rodin.businessprocessdemoapp.logic.Object1;

import java.util.LinkedHashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiagramTest {

    @Test
    void firstTestCase() {
        Object1 object1 = new Object1();

        object1.simpleMethod("value1");

        assertEquals(List.of(new MethodExecution("simpleMethod", mapOf("param", "value1"), "value1simpleMethod")),
                getTestCase("firstTestCase"));
    }

    @Test
    void secondTestCase() {
        Object1 object1 = new Object1();

        object1.simpleMethod("value1");

        assertEquals(List.of(new MethodExecution("simpleMethod", mapOf("param", "value1"), "value1simpleMethod")),
                getTestCase("secondTestCase"));
    }


    @Test
    void diagramWithTestCaseWithInnerMethodSameClass() {
        Object1 object1 = new Object1();

        object1.methodWithInnerCall("value1");

        assertEquals(List.of(new MethodExecution("methodWithInnerCall", mapOf("param", "value1"), "value1simpleMethodmethodWithInnerCall"),
                new MethodExecution("simpleMethod", mapOf("param", "value1"), "value1simpleMethod")), getTestCase("diagramWithTestCaseWithInnerMethodSameClass"));

    }

    @Test
    void diagramWithTestCaseWithInnerMethodDifferentClass() {
        Object1 object1 = new Object1();

        object1.methodWithDifferentObjectInnerCall("value1");

        assertEquals(List.of(new MethodExecution("methodWithDifferentObjectInnerCall", mapOf("param", "value1"), "value1doSomethingmethodWithInnerCall"),
                new MethodExecution("doSomething", mapOf("param", "value1"), "value1doSomething")), getTestCase("diagramWithTestCaseWithInnerMethodDifferentClass"));
    }


    private static List<MethodExecution> getTestCase(String testCaseName) {
        return GlobalDiagram.getDiagram()
                .getMethodExecutionsToTestCase().entrySet().stream().filter(entry -> entry.getKey().getTestCaseName().equals(testCaseName)).findFirst().get().getValue();
    }



    private LinkedHashMap<String, Object> mapOf(String key, String value) {
        LinkedHashMap<String, Object> input = new LinkedHashMap<>();
        input.put(key, value);
        return input;
    }


}
