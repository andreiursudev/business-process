package ro.rodin.businessprocessesdiagram.logic;

public class Object2 {
    public String doSomething(String param) {
        return param+" 2";
    }

    public String method1(String value) {
        return method2(value + " 1");
    }

    private String method2(String value) {
        return value + " 2";
    }
}
