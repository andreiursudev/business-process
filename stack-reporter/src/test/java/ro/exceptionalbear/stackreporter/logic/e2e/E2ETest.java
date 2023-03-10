package ro.exceptionalbear.stackreporter.logic.e2e;

import org.junit.jupiter.api.*;
import ro.exceptionalbear.stackreporter.logic.logic1.Object1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class E2ETest {

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
        Assertions.assertEquals("{\"packageName\":\"ro.exceptionalbear.stackreporter.logic.e2e\",\"className\":\"E2ETest\",\"methodName\":\"executeSimpleMethod\",\"input\":null,\"output\":null,\"children\":[{\"packageName\":\"ro.exceptionalbear.stackreporter.logic.logic1\",\"className\":\"Object1\",\"methodName\":\"simpleMethod\",\"input\":\"param = value\",\"output\":\"value 1\",\"children\":[]}]}",result);
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
        Assertions.assertEquals("{\"packageName\":\"ro.exceptionalbear.stackreporter.logic.e2e\",\"className\":\"E2ETest\",\"methodName\":\"executeSimpleMethodAgain\",\"input\":null,\"output\":null,\"children\":[{\"packageName\":\"ro.exceptionalbear.stackreporter.logic.logic1\",\"className\":\"Object1\",\"methodName\":\"simpleMethod\",\"input\":\"param = otherValue\",\"output\":\"otherValue 1\",\"children\":[]}]}",result);
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
        Assertions.assertEquals("{\"packageName\":\"ro.exceptionalbear.stackreporter.logic.e2e\",\"className\":\"E2ETest\",\"methodName\":\"executeMethodWithInnerCall\",\"input\":null,\"output\":null,\"children\":[{\"packageName\":\"ro.exceptionalbear.stackreporter.logic.logic1\",\"className\":\"Object1\",\"methodName\":\"methodWithInnerCall\",\"input\":\"param = value\",\"output\":\"value 1 1\",\"children\":[{\"packageName\":\"ro.exceptionalbear.stackreporter.logic.logic1\",\"className\":\"Object1\",\"methodName\":\"simpleMethod\",\"input\":\"param = value\",\"output\":\"value 1\",\"children\":[]}]}]}",result);
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
        Assertions.assertEquals("{\"packageName\":\"ro.exceptionalbear.stackreporter.logic.e2e\",\"className\":\"E2ETest\",\"methodName\":\"executeMethodWithDifferentObjectInnerCall\",\"input\":null,\"output\":null,\"children\":[{\"packageName\":\"ro.exceptionalbear.stackreporter.logic.logic1\",\"className\":\"Object1\",\"methodName\":\"methodWithDifferentObjectInnerCall\",\"input\":\"param = value\",\"output\":\"value 2 1\",\"children\":[{\"packageName\":\"ro.exceptionalbear.stackreporter.logic.logic2\",\"className\":\"Object2\",\"methodName\":\"doSomething\",\"input\":\"param = value\",\"output\":\"value 2\",\"children\":[]}]}]}",result);
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
        Assertions.assertEquals("{\"packageName\":\"ro.exceptionalbear.stackreporter.logic.e2e\",\"className\":\"E2ETest\",\"methodName\":\"executeMethodWithDifferentObjectsInnerCall\",\"input\":null,\"output\":null,\"children\":[{\"packageName\":\"ro.exceptionalbear.stackreporter.logic.logic1\",\"className\":\"Object1\",\"methodName\":\"methodWithDifferentObjectsInnerCall\",\"input\":\"param = value\",\"output\":\"value 2 value 3\",\"children\":[{\"packageName\":\"ro.exceptionalbear.stackreporter.logic.logic2\",\"className\":\"Object2\",\"methodName\":\"doSomething\",\"input\":\"param = value\",\"output\":\"value 2\",\"children\":[]},{\"packageName\":\"ro.exceptionalbear.stackreporter.logic.logic3and4\",\"className\":\"Object3\",\"methodName\":\"doSomethingElse\",\"input\":\"param = value\",\"output\":\"value 3\",\"children\":[]}]}]}",result);
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
        Assertions.assertEquals("{\"packageName\":\"ro.exceptionalbear.stackreporter.logic.e2e\",\"className\":\"E2ETest\",\"methodName\":\"executeMethodWithMoreDepthDifferentObjectsInnerCall\",\"input\":null,\"output\":null,\"children\":[{\"packageName\":\"ro.exceptionalbear.stackreporter.logic.logic1\",\"className\":\"Object1\",\"methodName\":\"methodWithMoreDepthDifferentObjectsInnerCall\",\"input\":\"param = value\",\"output\":\"value 2 value 4 3\",\"children\":[{\"packageName\":\"ro.exceptionalbear.stackreporter.logic.logic2\",\"className\":\"Object2\",\"methodName\":\"doSomething\",\"input\":\"param = value\",\"output\":\"value 2\",\"children\":[]},{\"packageName\":\"ro.exceptionalbear.stackreporter.logic.logic3and4\",\"className\":\"Object3\",\"methodName\":\"doSomethingElseWithObject4\",\"input\":\"param = value\",\"output\":\"value 4 3\",\"children\":[{\"packageName\":\"ro.exceptionalbear.stackreporter.logic.logic3and4\",\"className\":\"Object4\",\"methodName\":\"doSomethingNew\",\"input\":\"param = value\",\"output\":\"value 4\",\"children\":[]}]}]}]}",result);
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
        Assertions.assertEquals("{\"packageName\":\"ro.exceptionalbear.stackreporter.logic.e2e\",\"className\":\"E2ETest\",\"methodName\":\"executeMethodWithConditionTrue\",\"input\":null,\"output\":null,\"children\":[{\"packageName\":\"ro.exceptionalbear.stackreporter.logic.logic1\",\"className\":\"Object1\",\"methodName\":\"methodWithCondition\",\"input\":\"value = value1\",\"output\":\"value1 2\",\"children\":[{\"packageName\":\"ro.exceptionalbear.stackreporter.logic.logic2\",\"className\":\"Object2\",\"methodName\":\"doSomething\",\"input\":\"param = value1\",\"output\":\"value1 2\",\"children\":[]}]}]}",result);
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
        Assertions.assertEquals("{\"packageName\":\"ro.exceptionalbear.stackreporter.logic.e2e\",\"className\":\"E2ETest\",\"methodName\":\"executeMethodWithConditionFalse\",\"input\":null,\"output\":null,\"children\":[{\"packageName\":\"ro.exceptionalbear.stackreporter.logic.logic1\",\"className\":\"Object1\",\"methodName\":\"methodWithCondition\",\"input\":\"value = value2\",\"output\":\"value2 3\",\"children\":[{\"packageName\":\"ro.exceptionalbear.stackreporter.logic.logic3and4\",\"className\":\"Object3\",\"methodName\":\"doSomethingElse\",\"input\":\"param = value2\",\"output\":\"value2 3\",\"children\":[]}]}]}",result);
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
