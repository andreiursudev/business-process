package logic;

import org.junit.jupiter.api.Test;
import ro.rodin.businessprocessesdiagramdemoapp.logic.Object1;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LogicTest {

    @Test
    void simpleTestCase() {
        Object1 object1 = new Object1();

        String value = object1.simpleMethod("value");

        assertEquals("value 1", value);
    }

    @Test
    void simpleTestCaseInSeparateTestCase() {
        Object1 object1 = new Object1();

        String otherValue = object1.simpleMethod("otherValue");

        assertEquals("otherValue 1", otherValue);
    }


    @Test
    void testCaseWithInnerMethodCallInSameClass() {
        Object1 object1 = new Object1();

        String value = object1.methodWithInnerCall("value");

        assertEquals("value 1 1", value);
    }

   @Test
    void testCaseWithInnerMethodCallInDifferentClass() {
        Object1 object1 = new Object1();

       String value = object1.methodWithDifferentObjectInnerCall("value");

       assertEquals("value 2 1",value);
    }

    @Test
    void testCaseWithMultipleInnerMethodCallsInDifferentClass() {
        Object1 object1 = new Object1();

        String value = object1.methodWithDifferentObjectsInnerCall("value");

        assertEquals("value 2 value 3",value);
    }

    @Test
    void testCaseWithMoreDepthMethodCallsInDifferentClass() {
        Object1 object1 = new Object1();

        String value = object1.methodWithMoreDepthDifferentObjectsInnerCall("value");

        assertEquals("value 2 value 4 3",value);
    }

}
