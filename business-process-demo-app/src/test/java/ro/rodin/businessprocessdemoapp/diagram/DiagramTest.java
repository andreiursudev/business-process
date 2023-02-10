package ro.rodin.businessprocessdemoapp.diagram;

import org.junit.jupiter.api.Test;
import ro.rodin.businessprocessdemoapp.logic.Object1;

import java.util.LinkedHashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiagramTest {

    @Test
    void simpleTestCase() {
        Object1 object1 = new Object1();

        object1.simpleMethod("value1");

        assertEquals(List.of(new MethodExecution("simpleMethod", mapOf("param", "value1"), "value1simpleMethod")),
                getTestCase("simpleTestCase"));
    }

    @Test
    void simpleTestCaseInSeparateTestCase() {
        Object1 object1 = new Object1();

        object1.simpleMethod("value2");

        assertEquals(List.of(new MethodExecution("simpleMethod", mapOf("param", "value2"), "value2simpleMethod")),
                getTestCase("simpleTestCaseInSeparateTestCase"));
    }


    @Test
    void testCaseWithInnerMethodCallInSameClass() {
        Object1 object1 = new Object1();

        object1.methodWithInnerCall("value1");

        assertEquals(List.of(new MethodExecution("methodWithInnerCall", mapOf("param", "value1"), "value1simpleMethodmethodWithInnerCall"),
                new MethodExecution("simpleMethod", mapOf("param", "value1"), "value1simpleMethod")), getTestCase("testCaseWithInnerMethodCallInSameClass"));
    }

    @Test
    void testCaseWithInnerMethodCallInDifferentClass() {
        Object1 object1 = new Object1();

        object1.methodWithDifferentObjectInnerCall("value1");

        assertEquals(List.of(new MethodExecution("methodWithDifferentObjectInnerCall", mapOf("param", "value1"), "value1doSomethingmethodWithInnerCall"),
                new MethodExecution("doSomething", mapOf("param", "value1"), "value1doSomething")), getTestCase("testCaseWithInnerMethodCallInDifferentClass"));
    }

    @Test
    void testCaseWithMultipleInnerMethodCallsInDifferentClasss() {
        Object1 object1 = new Object1();

        object1.methodWithDifferentObjectsInnerCall("value1");

        assertEquals(List.of(new MethodExecution("methodWithDifferentObjectsInnerCall", mapOf("param", "value1"), "value1doSomethingvalue1doSomethingElse"),
                new MethodExecution("doSomething", mapOf("param", "value1"), "value1doSomething"),
                new MethodExecution("doSomethingElse", mapOf("param", "value1"), "value1doSomethingElse")), getTestCase("testCaseWithMultipleInnerMethodCallsInDifferentClasss"));
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
