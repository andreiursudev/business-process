package ro.rodin.businessprocessdemoapp;

import org.junit.jupiter.api.Test;
import ro.rodin.businessprocessdemoapp.concat.LiniarFlow;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DemoAppsTest {

    @Test
    void LiniarFlow() {
        String firstName = "Andrei";
        String lastName = "Ursu";

        LiniarFlow liniarFlow = new LiniarFlow(new SimplifyName(){
            @Override
            public String apply(String s, String s2) {
                write("SimplifyName");
                return super.apply(s, s2);

            }
        }, new FormatName(){
            @Override
            public String apply(String s) {
                write("FormatName");
                return super.apply(s);
            }
        }){
            @Override
            public String process(String firstName, String lastName) {
                write("LiniarFlow");
                return super.process(firstName, lastName);
            }
        };
        String result = liniarFlow.process(firstName, lastName);

        assertEquals("ANDREI URSU", result);
    }

    private static void write(String write) {
        FileWriter myWriter = null;
        try {
            myWriter = new FileWriter("filename.txt", true);
            BufferedWriter bw = new BufferedWriter(myWriter);
            bw.write(write);
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    void MultiEndFlow() {
        String firstName = "Andrei";
        String lastName = "Ursu";

        String result = new MultiEndFlow(new PersistName(), new NameToJson()).process(firstName, lastName);

        assertEquals("{\"firstName\" : \"Andrei\", \"lastName\" : \"Ursu\"}", result);


    }

    @Test
    void ConditionalFlow() {
        String firstName = "Andrei";
        String lastName = "Ursu";

        String result = new ConditionalFlow(new IsEmpty()).process(firstName, lastName);

        assertEquals("Ursu", result);


    }

    @Test
    void NameToJsonWrap() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        //LinkedList mockedList = mock(LinkedList.class);

        //verify(mockedList).get(0);
        NameToJson nameToJson = new NameToJson();

        Object toJson = wrapEndExecute(nameToJson, "toJson", "Andrei", "Ursu");


        assertEquals("{\"firstName\" : \"Andrei\", \"lastName\" : \"Ursu\"}", toJson);
    }

    @Test
    void NameToJson() {
        //LinkedList mockedList = mock(LinkedList.class);

        //verify(mockedList).get(0);
        NameToJson nameToJson = new NameToJson();

        Object toJson = nameToJson.toJson("Andrei", "Ursu");


        assertEquals("{\"firstName\" : \"Andrei\", \"lastName\" : \"Ursu\"}", toJson);
    }

    static Object wrapEndExecute(Object proxy, String method, Object... args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        for (Object arg : args) {
            System.out.println("input=" + arg);
        }

        Class[] classes1 = Arrays.stream(args).map(o -> o.getClass()).toArray(Class[]::new);

        Object result = proxy.getClass().getMethod(method, classes1).invoke(proxy, args);
        System.out.println("output=" + result);
        return result;
    }
}
