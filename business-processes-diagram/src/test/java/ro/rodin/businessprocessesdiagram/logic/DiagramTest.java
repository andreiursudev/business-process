package ro.rodin.businessprocessesdiagram.logic;

import org.junit.jupiter.api.*;
import ro.rodin.businessprocessesdiagram.diagram.Diagram;
import ro.rodin.businessprocessesdiagram.diagram.GlobalDiagram;
import ro.rodin.businessprocessesdiagram.diagram.MethodExecution;

import java.util.LinkedHashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DiagramTest {

    @Test
    @Order(1)
    void executeSimpleMethod() {
        Object1 object1 = new Object1();

        object1.simpleMethod("value");

        Assertions.assertEquals(new Diagram(new MethodExecution("DiagramTest_executeSimpleMethod", new MethodExecution("Object1_simpleMethod", "{\"param\":\"value\"}", "\"value 1\""))), GlobalDiagram.getDiagram());
    }

    @Test
    @Order(2)
    void executeSimpleMethodAgain() {
        Object1 object1 = new Object1();

        object1.simpleMethod("otherValue");

        Assertions.assertEquals(new Diagram(new MethodExecution("DiagramTest_executeSimpleMethodAgain", new MethodExecution("Object1_simpleMethod","{\"param\":\"otherValue\"}", "\"otherValue 1\""))), GlobalDiagram.getDiagram());
    }

    @Test
    @Order(3)
    void executeMethodWithInnerCall() {
        Object1 object1 = new Object1();

        object1.methodWithInnerCall("value");

        assertEquals(new Diagram(new MethodExecution("DiagramTest_executeMethodWithInnerCall",
                new MethodExecution("Object1_methodWithInnerCall", "{\"param\":\"value\"}", "\"value 1 1\"",
                        List.of(new MethodExecution("Object1_simpleMethod", "{\"param\":\"value\"}", "\"value 1\""))))), GlobalDiagram.getDiagram());
    }

    @Test
    @Order(4)
    void executeMethodWithDifferentObjectInnerCall() {
        Object1 object1 = new Object1();

        object1.methodWithDifferentObjectInnerCall("value");

        assertEquals(new Diagram(new MethodExecution("DiagramTest_executeMethodWithDifferentObjectInnerCall", new MethodExecution("Object1_methodWithDifferentObjectInnerCall", "{\"param\":\"value\"}", "\"value 2 1\"",
                List.of(new MethodExecution("Object2_doSomething", "{\"param\":\"value\"}", "\"value 2\"")))
        )), GlobalDiagram.getDiagram());
    }

    @Test
    @Order(5)
    void executeMethodWithDifferentObjectsInnerCall() {
        Object1 object1 = new Object1();

        object1.methodWithDifferentObjectsInnerCall("value");

        assertEquals(new Diagram(new MethodExecution("DiagramTest_executeMethodWithDifferentObjectsInnerCall", new MethodExecution("Object1_methodWithDifferentObjectsInnerCall", "{\"param\":\"value\"}", "\"value 2 value 3\"", List.of(
                new MethodExecution("Object2_doSomething", "{\"param\":\"value\"}", "\"value 2\""),
                new MethodExecution("Object3_doSomethingElse", "{\"param\":\"value\"}", "\"value 3\""))))), GlobalDiagram.getDiagram());
    }

    @Test
    @Order(6)
    void executeMethodWithMoreDepthDifferentObjectsInnerCall() {
        Object1 object1 = new Object1();

        object1.methodWithMoreDepthDifferentObjectsInnerCall("value");

        assertEquals(new Diagram(new MethodExecution("DiagramTest_executeMethodWithMoreDepthDifferentObjectsInnerCall", new MethodExecution("Object1_methodWithMoreDepthDifferentObjectsInnerCall", "{\"param\":\"value\"}", "\"value 2 value 4 3\"", List.of(
                new MethodExecution("Object2_doSomething", "{\"param\":\"value\"}", "\"value 2\""),
                new MethodExecution("Object3_doSomethingElseWithObject4", "{\"param\":\"value\"}", "\"value 4 3\"",
                        List.of(new MethodExecution("Object4_doSomethingNew", "{\"param\":\"value\"}", "\"value 4\"")))))
        )), GlobalDiagram.getDiagram());
    }

    @Test
    @Order(7)
    void executeMethodWithConditionTrue() {
        Object1 object1 = new Object1();

        object1.methodWithCondition("value1");

        assertEquals(new Diagram(new MethodExecution("DiagramTest_executeMethodWithConditionTrue", new MethodExecution("Object1_methodWithCondition", "{\"value\":\"value1\"}", "\"value1 2\"", List.of(new MethodExecution("Object2_doSomething", "{\"param\":\"value1\"}", "\"value1 2\"")))
        )), GlobalDiagram.getDiagram());
    }

    @Test
    @Order(8)
    void executeMethodWithConditionFalse() {
        Object1 object1 = new Object1();

        object1.methodWithCondition("value2");

        assertEquals(new Diagram(new MethodExecution("DiagramTest_executeMethodWithConditionFalse", new MethodExecution("Object1_methodWithCondition", "{\"value\":\"value2\"}", "\"value2 3\"", List.of(new MethodExecution("Object3_doSomethingElse", "{\"param\":\"value2\"}", "\"value2 3\"")))
        )), GlobalDiagram.getDiagram());
    }

}
