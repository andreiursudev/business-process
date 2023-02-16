package ro.rodin.businessprocessesdiagram.diagram;

import org.junit.jupiter.api.*;
import ro.rodin.businessprocessesdiagram.logic.Object1;
import ro.rodin.businessprocessesdiagram.logic.Object2;
import ro.rodin.businessprocessesdiagram.logic.Object3;

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
}
