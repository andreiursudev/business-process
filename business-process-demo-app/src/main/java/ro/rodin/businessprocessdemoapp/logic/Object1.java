package ro.rodin.businessprocessdemoapp.logic;

public class Object1 {

    private Object2 object2 = new Object2();

    public String simpleMethod(String param) {
        return param + "simpleMethod";
    }

    public String methodWithInnerCall(String param) {
        return simpleMethod(param) + "methodWithInnerCall";
    }

    public String methodWithDifferentObjectInnerCall(String param) {
        return object2.doSomething(param) + "methodWithInnerCall";
    }
}
