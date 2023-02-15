package ro.rodin.businessprocessesdiagram.logic;

public class Object2 {
    public String doSomething(String param) {
        return param+" 2";
    }

    public String method1(String value) {
        return "1 " + method2(value);
    }

    private String method2(String value) {
        return "2 " + value;
    }

    public String method3(String value) {
        return "3 " + method4(value) + " " + method5(value);
    }

    private String method4(String value) {
        return "4 " + value;
    }

    private String method5(String value) {
        return "5 " + value;
    }
}
