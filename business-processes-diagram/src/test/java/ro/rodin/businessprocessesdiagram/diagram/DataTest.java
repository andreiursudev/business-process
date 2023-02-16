package ro.rodin.businessprocessesdiagram.diagram;

import org.junit.jupiter.api.*;
import ro.rodin.businessprocessesdiagram.logic.*;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DataTest {

    @BeforeAll
    static void beforeAll() throws FileNotFoundException {
        new PrintWriter("testCases.js").close();
    }

    @Test
    @Order(1)
    void callMethod1() {
        Object1 object1 = new Object1();
        String value = object1.method1("value");
        assertEquals("value 1 ", value);
    }

    @Test
    @Order(2)
    void callMethod2Scenario1() {
        Object1 object1 = new Object1();
        String value = object1.method2("value1");
        assertEquals("value1 2 ", value);
    }

    @Test
    @Order(3)
    void callMethod2Scenario2() {
        Object1 object1 = new Object1();
        String value = object1.method2("value2");
        assertEquals("value2 2 ", value);
    }

    @Test
    @Order(4)
    void methodCallsAnotherMethodScenario1() {
        Object2 object2 = new Object2();
        String value = object2.method1("value1");
        assertEquals("value1 1 value1 2 ", value);
    }

    @Test
    @Order(5)
    void methodCallsAnotherMethodScenario2() {
        Object2 object2 = new Object2();
        String value = object2.method1("value2");
        assertEquals("value2 1 value2 2 ", value);
    }

    @Test
    @Order(6)
    void methodCallsTwoOtherMethodsScenario1() {
        Object2 object2 = new Object2();
        String value = object2.method3("value1");
        assertEquals("value1 3 value1 4 value1 5 ", value);
    }

    @Test
    @Order(7)
    void methodCallsTwoOtherMethodsScenario2() {
        Object2 object2 = new Object2();
        String value = object2.method3("value2");
        assertEquals("value2 3 value2 4 value2 5 ", value);
    }

    @Test
    @Order(8)
    void conditionalMethodCallTrue() {
        Object3 object3 = new Object3();
        String value = object3.method1("valueTrue");
        assertEquals("valueTrue 1 valueTrue 2 ", value);
    }

    @Test
    @Order(9)
    void conditionalMethodCallFalse() {
        Object3 object3 = new Object3();
        String value = object3.method1("valueFalse");
        assertEquals("valueFalse 1 valueFalse 3 ", value);
    }

    @Test
    @Order(10)
    void methodCallsInnerMethod() {
        Object4 object4 = new Object4();
        String value = object4.method1("value1");
        assertEquals("value1 1 value1 2 value1 3 ", value);
    }

    @Test
    @Order(11)
    void methodCallsInnerConditionMethodScenario1() {
        Object5 object5 = new Object5();
        String value = object5.method1("true true");
        assertEquals("true true 1 true true 2 true true 3 ", value);
    }

    @Test
    @Order(12)
    void methodCallsInnerConditionMethodScenario2() {
        Object5 object5 = new Object5();
        String value = object5.method1("true false");
        assertEquals("true false 1 true false 2 true false 4 ", value);
    }

    @Test
    @Order(13)
    void methodCallsInnerConditionMethodScenario3() {
        Object5 object5 = new Object5();
        String value = object5.method1("false true");
        assertEquals("false true 1 false true 5 false true 6 ", value);
    }

    @Test
    @Order(14)
    void methodCallsInnerConditionMethodScenario4() {
        Object5 object5 = new Object5();
        String value = object5.method1("false false");
        assertEquals("false false 1 false false 5 false false 7 ", value);
    }

    @Test
    @Order(91)
    void complexMethodCallScenario1() {
        Object6 object6 = new Object6();
        String value = object6.method1("true true");
        assertEquals("true true 1 true true 2 true true 3 true true 4 true true 7 true true 71 true true 72 true true 73 true true 74 true true 75 true true 77 true true 6 ", value);
    }

    @Test
    @Order(92)
    void complexMethodCallScenario2() {
        Object6 object6 = new Object6();
        String value = object6.method1("true false");
        assertEquals("true false 1 true false 2 true false 3 true false 4 true false 7 true false 71 true false 72 true false 73 true false 74 true false 76 true false 77 true false 6 ", value);
    }

    @Test
    @Order(93)
    void complexMethodCallScenario3() {
        Object6 object6 = new Object6();
        String value = object6.method1("false true");
        assertEquals("false true 1 false true 2 false true 3 false true 5 false true 8 false true 81 false true 811 false true 812 false true 82 false true 821 false true 822 false true 8221 false true 8222 false true 8223 false true 8225 false true 823 false true 6 ", value);
    }
    @Test
    @Order(94)
    void complexMethodCallScenario4() {
        Object6 object6 = new Object6();
        String value = object6.method1("false false");
        assertEquals("false false 1 false false 2 false false 3 false false 5 false false 8 false false 81 false false 811 false false 812 false false 813 false false 82 false false 821 false false 822 false false 8221 false false 8222 false false 8224 false false 8225 false false 823 false false 6 ", value);
    }
}
