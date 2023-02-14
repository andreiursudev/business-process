package ro.rodin.businessprocessesdiagram.diagram;

import org.junit.jupiter.api.Test;
import ro.rodin.businessprocessesdiagram.logic.Object1;

import java.util.LinkedHashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiagramTest {

    @Test
    void simpleTestCase() {
        Object1 object1 = new Object1();

        object1.simpleMethod("value");

        assertEquals(List.of(new MethodExecution("simpleMethod", mapOf("param", "value"), "value 1")),
                getTestCase("simpleTestCase"));
    }

    @Test
    void simpleTestCaseInSeparateTestCase() {
        Object1 object1 = new Object1();

        object1.simpleMethod("otherValue");

        assertEquals(List.of(new MethodExecution("simpleMethod", mapOf("param", "otherValue"), "otherValue 1")),
                getTestCase("simpleTestCaseInSeparateTestCase"));
    }


    @Test
    void testCaseWithInnerMethodCallInSameClass() {
        Object1 object1 = new Object1();

        object1.methodWithInnerCall("value");

        assertEquals(List.of(
                new MethodExecution("methodWithInnerCall", mapOf("param", "value"), "value 1 1",
                        List.of(new MethodExecution("simpleMethod", mapOf("param", "value"), "value 1")))
                ),
                getTestCase("testCaseWithInnerMethodCallInSameClass"));
    }

   @Test
    void testCaseWithInnerMethodCallInDifferentClass() {
        Object1 object1 = new Object1();

        object1.methodWithDifferentObjectInnerCall("value");

        assertEquals(List.of(
                new MethodExecution("methodWithDifferentObjectInnerCall", mapOf("param", "value"), "value 2 1",
                        List.of(new MethodExecution("doSomething", mapOf("param", "value"), "value 2")))
                ),
                getTestCase("testCaseWithInnerMethodCallInDifferentClass"));
    }

    @Test
    void testCaseWithMultipleInnerMethodCallsInDifferentClass() {
        Object1 object1 = new Object1();

        object1.methodWithDifferentObjectsInnerCall("value");

        assertEquals(List.of(
                new MethodExecution("methodWithDifferentObjectsInnerCall", mapOf("param", "value"), "value 2 value 3", List.of(
                        new MethodExecution("doSomething", mapOf("param", "value"), "value 2"),
                        new MethodExecution("doSomethingElse", mapOf("param", "value"), "value 3")))),
                getTestCase("testCaseWithMultipleInnerMethodCallsInDifferentClass"));
    }

    @Test
    void testCaseWithMoreDepthMethodCallsInDifferentClass() {
        Object1 object1 = new Object1();

        object1.methodWithMoreDepthDifferentObjectsInnerCall("value");

        assertEquals(List.of(
                new MethodExecution("methodWithMoreDepthDifferentObjectsInnerCall", mapOf("param", "value"), "value 2 value 4 3",List.of(
                        new MethodExecution("doSomething", mapOf("param", "value"), "value 2"),
                        new MethodExecution("doSomethingElseWithObject4", mapOf("param", "value"), "value 4 3",
                                List.of(new MethodExecution("doSomethingNew", mapOf("param", "value"), "value 4")))))
                ),
                getTestCase("testCaseWithMoreDepthMethodCallsInDifferentClass"));
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
