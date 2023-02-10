package ro.rodin.businessprocessdemoapp.logic;

public class Object1 {

    private Object2 object2 = new Object2();
    private Object3 object3 = new Object3();

    public String simpleMethod(String param) {
        return param + " 1";
    }

    public String methodWithInnerCall(String param) {
        return simpleMethod(param) + " 1";
    }

    public String methodWithDifferentObjectInnerCall(String param) {
        return object2.doSomething(param) + " 1";
    }

    public String methodWithDifferentObjectsInnerCall(String param) {
        String s1 = object2.doSomething(param);
        String s2 = object3.doSomethingElse(param);
        return s1 +" "+ s2;
    }

    public String methodWithMoreDepthDifferentObjectsInnerCall(String param) {
        String s1 = object2.doSomething(param);
        String s2 = object3.doSomethingElseWithObject4(param);
        return s1 +" "+ s2;
    }
}