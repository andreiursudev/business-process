package ro.rodin.businessprocessesdiagram.diagram;

import org.junit.jupiter.api.*;
import ro.rodin.businessprocessesdiagram.logic.Object1;
import ro.rodin.businessprocessesdiagram.logic.Object2;

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
        assertEquals("result value", value);
    }

    @Test
    @Order(2)
    void callMethod2Scenario1() {
        Object1 object1 = new Object1();
        String value = object1.method2("value1");
        assertEquals("result value1", value);
    }

    @Test
    @Order(3)
    void callMethod2Scenario2() {
        Object1 object1 = new Object1();
        String value = object1.method2("value2");
        assertEquals("result value2", value);
    }

    @Test
    @Order(4)
    void methodCallsAnotherMethodScenario1() {
        Object2 object2 = new Object2();
        String value = object2.method1("value1");
        assertEquals("value1 1 2", value);
    }

    @Test
    @Order(5)
    void methodCallsAnotherMethodScenario2() {
        Object2 object2 = new Object2();
        String value = object2.method1("value2");
        assertEquals("value2 1 2", value);
    }
}
