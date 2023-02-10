package ro.rodin.businessprocessdemoapp.diagram;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import ro.rodin.businessprocessdemoapp.logic.Object1;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiagramTest {

    @AfterEach
    void tearDown() {
        GlobalDiagram.getDiagram().clean();
    }

    @Test
    void diagramWithOneTestCase() {
        Object1 object1 = new Object1();

        call1(object1, "value1");

        Map.Entry<TestCase, List<MethodExecution>> testCase = getTestCase(0);
        assertEquals("call1", testCase.getKey().getTestCaseName());
        assertEquals(List.of(new MethodExecution("simpleMethod", mapOf("param", "value1"), "value1simpleMethod")), testCase.getValue());
    }


    @Test
    void diagramWithTwoTestCases() {
        Object1 object1 = new Object1();

        call1(object1, "value1");
        call2(object1, "value2");

        Map.Entry<TestCase, List<MethodExecution>> firstTestCase = getTestCase(0);
        assertEquals("call1", firstTestCase.getKey().getTestCaseName());
        assertEquals(List.of(new MethodExecution("simpleMethod", mapOf("param", "value1"), "value1simpleMethod")), firstTestCase.getValue());
        Map.Entry<TestCase, List<MethodExecution>> secondTestCase = getTestCase(1);
        assertEquals("call2", secondTestCase.getKey().getTestCaseName());
        assertEquals(List.of(new MethodExecution("simpleMethod", mapOf("param", "value2"), "value2simpleMethod")), secondTestCase.getValue());
    }

    @Test
    void diagramWithTestCaseWithInnerMethodSameClass() {
        Object1 object1 = new Object1();

        callMethodWithInnerCall(object1, "value1");

        Map.Entry<TestCase, List<MethodExecution>> firstTestCase = getTestCase(0);
        assertEquals("callMethodWithInnerCall", firstTestCase.getKey().getTestCaseName());
        assertEquals(List.of(new MethodExecution("methodWithInnerCall", mapOf("param", "value1"), "value1simpleMethodmethodWithInnerCall"),
                new MethodExecution("simpleMethod", mapOf("param", "value1inner"), "value1simpleMethod")), firstTestCase.getValue());

    }

    @Test
    void diagramWithTestCaseWithInnerMethodDifferentClass() {
        Object1 object1 = new Object1();

        String result = callMethodWithDifferentObjectInnerCall(object1, "value1");

        Map.Entry<TestCase, List<MethodExecution>> firstTestCase = getTestCase(0);
        assertEquals("callMethodWithDifferentObjectInnerCall", firstTestCase.getKey().getTestCaseName());
        assertEquals(List.of(new MethodExecution("methodWithDifferentObjectInnerCall", mapOf("param", "value1"), "value1simpleMethodmethodWithInnerCall"),
                new MethodExecution("simpleMethod", mapOf("param", "value1inner"), "value1simpleMethod")), firstTestCase.getValue());
    }


    private static Map.Entry<TestCase, List<MethodExecution>> getTestCase(Integer index) {
        Map.Entry<TestCase, List<MethodExecution>> testCase = (Map.Entry<TestCase, List<MethodExecution>>) GlobalDiagram.getDiagram()
                .getMethodExecutionsToTestCase().entrySet().toArray()[index];
        return testCase;
    }

    private String callMethodWithDifferentObjectInnerCall(Object1 object1, String value1) {
        return object1.methodWithDifferentObjectInnerCall(value1);
    }

    private String callMethodWithInnerCall(Object1 object1, String value1) {
        return object1.methodWithInnerCall(value1);
    }

    private String call1(Object1 obecjt1, String value) {
        return obecjt1.simpleMethod(value);
    }

    private String call2(Object1 obecjt1, String value) {
        return obecjt1.simpleMethod(value);
    }

    private LinkedHashMap<String, Object> mapOf(String key, String value) {
        LinkedHashMap<String, Object> input = new LinkedHashMap<>();
        input.put(key, value);
        return input;
    }

    private LinkedHashMap<Method, MethodExecution> mapOf(Method key, MethodExecution value) {
        LinkedHashMap<Method, MethodExecution> input = new LinkedHashMap<>();
        input.put(key, value);
        return input;
    }

    private LinkedHashMap<Method, MethodExecution> mapOf(Method key1, MethodExecution value1, Method key2, MethodExecution value2) {
        LinkedHashMap<Method, MethodExecution> input = new LinkedHashMap<>();
        input.put(key1, value1);
        input.put(key2, value2);
        return input;
    }

    private LinkedHashMap<TestCase, LinkedHashMap<Method, MethodExecution>> mapOf(TestCase key, LinkedHashMap<Method, MethodExecution> value) {
        LinkedHashMap<TestCase, LinkedHashMap<Method, MethodExecution>> input = new LinkedHashMap<>();
        input.put(key, value);
        return input;
    }

    private LinkedHashMap<TestCase, LinkedHashMap<Method, MethodExecution>> mapOf(TestCase key1, LinkedHashMap<Method, MethodExecution> value1, TestCase key2, LinkedHashMap<Method, MethodExecution> value2) {
        LinkedHashMap<TestCase, LinkedHashMap<Method, MethodExecution>> input = new LinkedHashMap<>();
        input.put(key1, value1);
        input.put(key2, value2);
        return input;
    }

    private LinkedHashMap<MethodUnderTest, LinkedHashMap<TestCase, LinkedHashMap<Method, MethodExecution>>> mapOf(MethodUnderTest key, LinkedHashMap<TestCase, LinkedHashMap<Method, MethodExecution>> value) {
        LinkedHashMap<MethodUnderTest, LinkedHashMap<TestCase, LinkedHashMap<Method, MethodExecution>>> input = new LinkedHashMap<>();
        input.put(key, value);
        return input;
    }

    private LinkedHashSet<Method> setOf(Method method1) {
        LinkedHashSet<Method> set = new LinkedHashSet<>();
        set.add(method1);
        return set;
    }

    private LinkedHashSet<Method> setOf(Method method1, Method method2) {
        LinkedHashSet<Method> set = new LinkedHashSet<>();
        set.add(method1);
        set.add(method2);
        return set;
    }

}
