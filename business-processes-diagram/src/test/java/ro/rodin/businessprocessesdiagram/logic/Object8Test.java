package ro.rodin.businessprocessesdiagram.logic;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class Object8Test {

    @Test
    @Order(1)
    void injectObjectScenario1() {
        Object8 object8 = new Object8(new Object9());
        String value = object8.method1("value");
        assertEquals("value 1  2 ", value);
    }

    @Test
    @Order(2)
    void injectMockScenario2() {
        Object9 mock = mock(Object9.class);
        when(mock.method2()).thenReturn(" 3 ");
        Object8 object8 = new Object8(mock);
        String value = object8.method1("value");
        assertEquals("value 1  3 ", value);
    }
}