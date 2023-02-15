package ro.rodin.businessprocessesdiagram.diagram;

import org.junit.jupiter.api.Test;
import ro.rodin.businessprocessesdiagram.logic.Object1;

import java.util.LinkedHashMap;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsIterableContaining.hasItems;

public class DiagramTest {

    private static final List<TestCase> testCases = GlobalDiagram.getDiagram().getTestCases();

    @Test
    void simpleTestCase() {
        Object1 object1 = new Object1();

        object1.simpleMethod("value");

        assertThat(testCases, hasItems(
                new TestCase("simpleTestCase", new MethodExecution("simpleMethod", mapOf("param", "value"), "value 1"))
        ));

    }

    @Test
    void simpleTestCaseInSeparateTestCase() {
        Object1 object1 = new Object1();

        object1.simpleMethod("otherValue");

        assertThat(testCases, hasItems(
                new TestCase("simpleTestCaseInSeparateTestCase",new MethodExecution("simpleMethod", mapOf("param", "otherValue"), "otherValue 1"))
        ));
    }


    @Test
    void testCaseWithInnerMethodCallInSameClass() {
        Object1 object1 = new Object1();

        object1.methodWithInnerCall("value");

        assertThat(testCases, hasItems(
                new TestCase("testCaseWithInnerMethodCallInSameClass",
                new MethodExecution("methodWithInnerCall", mapOf("param", "value"), "value 1 1",
                        List.of(new MethodExecution("simpleMethod", mapOf("param", "value"), "value 1")))
                )));
    }

   @Test
    void testCaseWithInnerMethodCallInDifferentClass() {
        Object1 object1 = new Object1();

        object1.methodWithDifferentObjectInnerCall("value");

       assertThat(testCases, hasItems(
               new TestCase("testCaseWithInnerMethodCallInDifferentClass",new MethodExecution("methodWithDifferentObjectInnerCall", mapOf("param", "value"), "value 2 1",
                        List.of(new MethodExecution("doSomething", mapOf("param", "value"), "value 2")))
                )));
    }

    @Test
    void testCaseWithMultipleInnerMethodCallsInDifferentClass() {
        Object1 object1 = new Object1();

        object1.methodWithDifferentObjectsInnerCall("value");

        assertThat(testCases, hasItems(
                new TestCase("testCaseWithMultipleInnerMethodCallsInDifferentClass", new MethodExecution("methodWithDifferentObjectsInnerCall", mapOf("param", "value"), "value 2 value 3", List.of(
                        new MethodExecution("doSomething", mapOf("param", "value"), "value 2"),
                        new MethodExecution("doSomethingElse", mapOf("param", "value"), "value 3"))))));
    }

    @Test
    void testCaseWithMoreDepthMethodCallsInDifferentClass() {
        Object1 object1 = new Object1();

        object1.methodWithMoreDepthDifferentObjectsInnerCall("value");

        assertThat(testCases, hasItems(
                new TestCase("testCaseWithMoreDepthMethodCallsInDifferentClass", new MethodExecution("methodWithMoreDepthDifferentObjectsInnerCall", mapOf("param", "value"), "value 2 value 4 3",List.of(
                        new MethodExecution("doSomething", mapOf("param", "value"), "value 2"),
                        new MethodExecution("doSomethingElseWithObject4", mapOf("param", "value"), "value 4 3",
                                List.of(new MethodExecution("doSomethingNew", mapOf("param", "value"), "value 4")))))
                )));
    }

    private LinkedHashMap<String, Object> mapOf(String key, String value) {
        LinkedHashMap<String, Object> input = new LinkedHashMap<>();
        input.put(key, value);
        return input;
    }

}
