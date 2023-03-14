package ro.exceptionalbear.stackreporter.aspectjtomethodexecution;

import org.junit.jupiter.api.Test;
import ro.exceptionalbear.stackreporter.adapter.aspectjtomethodexecution.InputFactory;
import ro.exceptionalbear.stackreporter.aspect.Person;

import static org.junit.jupiter.api.Assertions.*;

class InputFactoryTest {
    @Test
    void variousInputParameters() {
        String input = InputFactory.getInput(new String[]{"parameter1", "parameter2", "parameter3"}, new Object[]{null, "someString", new Person("Andrei", "Ursu")});

        assertEquals("""
                parameter1 = null
                parameter2 = someString
                parameter3 = Person{firstName='Andrei', lastName='Ursu'}
                """, input);
    }
}