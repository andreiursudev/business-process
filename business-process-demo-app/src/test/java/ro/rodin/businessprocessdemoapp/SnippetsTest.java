package ro.rodin.businessprocessdemoapp;

import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SnippetsTest {

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
    void NameToJsonWrap() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        NameToJson nameToJson = new NameToJson();

        Object toJson = wrapEndExecute(nameToJson, "toJson", "Andrei", "Ursu");


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
