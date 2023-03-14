package ro.exceptionalbear.stackreporter.logic;

import org.junit.jupiter.api.*;
import ro.exceptionalbear.stackreporter.logic.logic1.Object1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DiagramTest {

    @Test
    @Order(1)
    void executeSimpleMethod(){
        Object1 object1 = new Object1();

        object1.simpleMethod("value");
    }

    @Test
    @Order(2)
    void executeSimpleMethodAssert() throws FileNotFoundException {
        String result = readLog();
        Assertions.assertEquals("{\"packageName\":\"ro.exceptionalbear.stackreporter.logic\",\"className\":\"DiagramTest\",\"methodName\":\"executeSimpleMethod\",\"input\":\"\",\"output\":\"\",\"children\":[{\"packageName\":\"ro.exceptionalbear.stackreporter.logic.logic1\",\"className\":\"Object1\",\"methodName\":\"simpleMethod\",\"input\":\"{param=value}\",\"output\":\"\\\"value 1\\\"\",\"children\":[],\"id\":\"ro.exceptionalbear.stackreporter.logic.logic1Object1simpleMethod\"}],\"id\":\"ro.exceptionalbear.stackreporter.logicDiagramTestexecuteSimpleMethod\"}",result);
    }

    @Test
    @Order(3)
    void executeSimpleMethodAgain() {
        Object1 object1 = new Object1();

        object1.simpleMethod("otherValue");
    }

    @Test
    @Order(4)
    void executeSimpleMethodAgainAssert() throws FileNotFoundException {
        String result = readLog();
        Assertions.assertEquals("{\"packageName\":\"ro.rodin.businessprocessesdiagram.logic\",\"className\":\"DiagramTest\",\"methodName\":\"executeSimpleMethodAgain\",\"input\":null,\"output\":\"null\",\"children\":[{\"packageName\":\"ro.rodin.businessprocessesdiagram.logic.logic1\",\"className\":\"Object1\",\"methodName\":\"simpleMethod\",\"input\":\"{\\r\\n  \\\"param\\\" : \\\"otherValue\\\"\\r\\n}\",\"output\":\"\\\"otherValue 1\\\"\",\"children\":[]}]}",result);
    }

    @Test
    @Order(5)
    void executeMethodWithInnerCall() {
        Object1 object1 = new Object1();

        object1.methodWithInnerCall("value");
    }

    @Test
    @Order(6)
    void executeMethodWithInnerCallAssert() throws FileNotFoundException {
        String result = readLog();
        Assertions.assertEquals("{\"packageName\":\"ro.rodin.businessprocessesdiagram.logic\",\"className\":\"DiagramTest\",\"methodName\":\"executeMethodWithInnerCall\",\"input\":null,\"output\":\"null\",\"children\":[{\"packageName\":\"ro.rodin.businessprocessesdiagram.logic.logic1\",\"className\":\"Object1\",\"methodName\":\"methodWithInnerCall\",\"input\":\"{\\r\\n  \\\"param\\\" : \\\"value\\\"\\r\\n}\",\"output\":\"\\\"value 1 1\\\"\",\"children\":[{\"packageName\":\"ro.rodin.businessprocessesdiagram.logic.logic1\",\"className\":\"Object1\",\"methodName\":\"simpleMethod\",\"input\":\"{\\r\\n  \\\"param\\\" : \\\"value\\\"\\r\\n}\",\"output\":\"\\\"value 1\\\"\",\"children\":[]}]}]}",result);
    }

    @Test
    @Order(7)
    void executeMethodWithDifferentObjectInnerCall() {
        Object1 object1 = new Object1();

        object1.methodWithDifferentObjectInnerCall("value");
    }

    @Test
    @Order(8)
    void executeMethodWithDifferentObjectInnerCallAssert() throws FileNotFoundException {
        String result = readLog();
        Assertions.assertEquals("{\"packageName\":\"ro.rodin.businessprocessesdiagram.logic\",\"className\":\"DiagramTest\",\"methodName\":\"executeMethodWithDifferentObjectInnerCall\",\"input\":null,\"output\":\"null\",\"children\":[{\"packageName\":\"ro.rodin.businessprocessesdiagram.logic.logic1\",\"className\":\"Object1\",\"methodName\":\"methodWithDifferentObjectInnerCall\",\"input\":\"{\\r\\n  \\\"param\\\" : \\\"value\\\"\\r\\n}\",\"output\":\"\\\"value 2 1\\\"\",\"children\":[{\"packageName\":\"ro.rodin.businessprocessesdiagram.logic.logic2\",\"className\":\"Object2\",\"methodName\":\"doSomething\",\"input\":\"{\\r\\n  \\\"param\\\" : \\\"value\\\"\\r\\n}\",\"output\":\"\\\"value 2\\\"\",\"children\":[]}]}]}",result);
    }

    @Test
    @Order(9)
    void executeMethodWithDifferentObjectsInnerCall() {
        Object1 object1 = new Object1();

        object1.methodWithDifferentObjectsInnerCall("value");
    }

    @Test
    @Order(10)
    void executeMethodWithDifferentObjectsInnerCallAssert() throws FileNotFoundException {
        String result = readLog();
        Assertions.assertEquals(" {\"packageName\":\"ro.rodin.businessprocessesdiagram.logic\",\"className\":\"DiagramTest\",\"methodName\":\"executeSimpleMethod\",\"input\":null,\"output\":\"null\",\"children\":[{\"packageName\":\"ro.rodin.businessprocessesdiagram.logic.logic1\",\"className\":\"Object1\",\"methodName\":\"simpleMethod\",\"input\":\"{\\r\\n  \\\"param\\\" : \\\"value\\\"\\r\\n}\",\"output\":\"\\\"value 1\\\"\",\"children\":[]}]}",result);
    }

    @Test
    @Order(11)
    void executeMethodWithMoreDepthDifferentObjectsInnerCall() {
        Object1 object1 = new Object1();

        object1.methodWithMoreDepthDifferentObjectsInnerCall("value");
    }

    @Test
    @Order(12)
    void executeMethodWithMoreDepthDifferentObjectsInnerCallAssert() throws FileNotFoundException {
        String result = readLog();
        Assertions.assertEquals(" {\"packageName\":\"ro.rodin.businessprocessesdiagram.logic\",\"className\":\"DiagramTest\",\"methodName\":\"executeSimpleMethod\",\"input\":null,\"output\":\"null\",\"children\":[{\"packageName\":\"ro.rodin.businessprocessesdiagram.logic.logic1\",\"className\":\"Object1\",\"methodName\":\"simpleMethod\",\"input\":\"{\\r\\n  \\\"param\\\" : \\\"value\\\"\\r\\n}\",\"output\":\"\\\"value 1\\\"\",\"children\":[]}]}",result);
    }

    @Test
    @Order(13)
    void executeMethodWithConditionTrue() {
        Object1 object1 = new Object1();

        object1.methodWithCondition("value1");
    }

    @Test
    @Order(14)
    void executeMethodWithConditionTrueAssert() throws FileNotFoundException {
        String result = readLog();
        Assertions.assertEquals(" {\"packageName\":\"ro.rodin.businessprocessesdiagram.logic\",\"className\":\"DiagramTest\",\"methodName\":\"executeSimpleMethod\",\"input\":null,\"output\":\"null\",\"children\":[{\"packageName\":\"ro.rodin.businessprocessesdiagram.logic.logic1\",\"className\":\"Object1\",\"methodName\":\"simpleMethod\",\"input\":\"{\\r\\n  \\\"param\\\" : \\\"value\\\"\\r\\n}\",\"output\":\"\\\"value 1\\\"\",\"children\":[]}]}",result);
    }

    @Test
    @Order(15)
    void executeMethodWithConditionFalse() {
        Object1 object1 = new Object1();

        object1.methodWithCondition("value2");
    }

    @Test
    @Order(16)
    void executeMethodWithConditionFalseAssert() throws FileNotFoundException {
        String result = readLog();
        Assertions.assertEquals(" {\"packageName\":\"ro.rodin.businessprocessesdiagram.logic\",\"className\":\"DiagramTest\",\"methodName\":\"executeSimpleMethod\",\"input\":null,\"output\":\"null\",\"children\":[{\"packageName\":\"ro.rodin.businessprocessesdiagram.logic.logic1\",\"className\":\"Object1\",\"methodName\":\"simpleMethod\",\"input\":\"{\\r\\n  \\\"param\\\" : \\\"value\\\"\\r\\n}\",\"output\":\"\\\"value 1\\\"\",\"children\":[]}]}",result);
    }


    private static String readLog() throws FileNotFoundException {
        File file = new File("methodExecutions.js");
        Scanner scanner = new Scanner(file);
        String lastLine = "";
        while (scanner.hasNextLine()) {
            lastLine = scanner.nextLine();
        }
        String data = lastLine.split("var methodExecution\\d+ = ")[1];
        scanner.close();
        file.delete();
        return data;
    }

}
