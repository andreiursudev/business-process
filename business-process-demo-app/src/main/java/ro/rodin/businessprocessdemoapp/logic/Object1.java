package ro.rodin.businessprocessdemoapp.logic;

public class Object1 {

    private Object2 object2 = new Object2();
    private Object3 object3 = new Object3();

    public String simpleMethod(String param) {
        return param + "simpleMethod";
    }

    public String methodWithInnerCall(String param) {
        return simpleMethod(param) + "methodWithInnerCall";
    }

    public String methodWithDifferentObjectInnerCall(String param) {
        return object2.doSomething(param) + "methodWithInnerCall";
    }

    public String methodWithDifferentObjectsInnerCall(String param) {
        String s1 = object2.doSomething(param);
        String s2 = object3.doSomethingElse(param);
        return s1 + s2;
    }
}
