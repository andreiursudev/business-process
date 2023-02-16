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
    void complexMethodCallScenario1() {
        Object5 object5 = new Object5();
        String value = object5.method1("valueTrue");
        assertEquals("valueTrue 1 valueTrue 2 valueTrue 3 valueTrue 4 valueTrue 7 valueTrue 71 valueTrue 72 valueTrue 73 valueTrue 74 valueTrue 75 valueTrue 77 valueTrue 6 ", value);
    }

    @Test
    @Order(12)
    void complexMethodCallScenario2() {
        Object5 object5 = new Object5();
        String value = object5.method1("valueFalse");
        assertEquals("valueFalse 1 valueFalse 2 valueFalse 3 valueFalse 5 valueFalse 8 valueFalse 81 valueFalse 811 valueFalse 812 valueFalse 813 valueFalse 82 valueFalse 821 valueFalse 822 valueFalse 823 valueFalse 6 ", value);
    }
}
