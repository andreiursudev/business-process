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

        assertEquals(new TestCase("simpleTestCase", new MethodExecution("simpleMethod", mapOf("param", "value"), "value 1")), getLastTestCase());

    }



    @Test
    void simpleTestCaseInSeparateTestCase() {
        Object1 object1 = new Object1();

        object1.simpleMethod("otherValue");

        assertEquals(new TestCase("simpleTestCaseInSeparateTestCase",new MethodExecution("simpleMethod", mapOf("param", "otherValue"), "otherValue 1")), getLastTestCase());
    }


    @Test
    void testCaseWithInnerMethodCallInSameClass() {
        Object1 object1 = new Object1();

        object1.methodWithInnerCall("value");

        assertEquals(new TestCase("testCaseWithInnerMethodCallInSameClass",
                new MethodExecution("methodWithInnerCall", mapOf("param", "value"), "value 1 1",
                        List.of(new MethodExecution("simpleMethod", mapOf("param", "value"), "value 1")))), getLastTestCase());
    }

   @Test
    void testCaseWithInnerMethodCallInDifferentClass() {
        Object1 object1 = new Object1();

        object1.methodWithDifferentObjectInnerCall("value");

       assertEquals(new TestCase("testCaseWithInnerMethodCallInDifferentClass",new MethodExecution("methodWithDifferentObjectInnerCall", mapOf("param", "value"), "value 2 1",
                        List.of(new MethodExecution("doSomething", mapOf("param", "value"), "value 2")))
                ), getLastTestCase());
    }

    @Test
    void testCaseWithMultipleInnerMethodCallsInDifferentClass() {
        Object1 object1 = new Object1();

        object1.methodWithDifferentObjectsInnerCall("value");

        assertEquals(new TestCase("testCaseWithMultipleInnerMethodCallsInDifferentClass", new MethodExecution("methodWithDifferentObjectsInnerCall", mapOf("param", "value"), "value 2 value 3", List.of(
                        new MethodExecution("doSomething", mapOf("param", "value"), "value 2"),
                        new MethodExecution("doSomethingElse", mapOf("param", "value"), "value 3")))), getLastTestCase());
    }

    @Test
    void testCaseWithMoreDepthMethodCallsInDifferentClass() {
        Object1 object1 = new Object1();

        object1.methodWithMoreDepthDifferentObjectsInnerCall("value");

        assertEquals(new TestCase("testCaseWithMoreDepthMethodCallsInDifferentClass", new MethodExecution("methodWithMoreDepthDifferentObjectsInnerCall", mapOf("param", "value"), "value 2 value 4 3",List.of(
                        new MethodExecution("doSomething", mapOf("param", "value"), "value 2"),
                        new MethodExecution("doSomethingElseWithObject4", mapOf("param", "value"), "value 4 3",
                                List.of(new MethodExecution("doSomethingNew", mapOf("param", "value"), "value 4")))))
                ), getLastTestCase());
    }

    @Test
    void testCaseWithConditionTrue() {
        Object1 object1 = new Object1();

        object1.methodWithCondition("value1");

        assertEquals(new TestCase("testCaseWithConditionTrue", new MethodExecution("methodWithCondition", mapOf("param", "value1"), "value1 2",List.of())
        ), getLastTestCase());
    }

    @Test
    void testCaseWithConditionFalse() {
        Object1 object1 = new Object1();

        object1.methodWithCondition("value2");

        assertEquals(new TestCase("testCaseWithConditionFalse", new MethodExecution("methodWithCondition", mapOf("param", "value2"), "value2 3",List.of())
        ), getLastTestCase());
    }

    private static TestCase getLastTestCase() {
        List<TestCase> testCases = GlobalDiagram.getDiagram().getTestCases();
        return testCases.get(testCases.size() - 1);
    }

    private LinkedHashMap<String, Object> mapOf(String key, String value) {
        LinkedHashMap<String, Object> input = new LinkedHashMap<>();
        input.put(key, value);
        return input;
    }

}
