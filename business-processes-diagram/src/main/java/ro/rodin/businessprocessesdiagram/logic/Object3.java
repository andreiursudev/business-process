package ro.rodin.businessprocessesdiagram.logic;

public class Object3 {
    private Object4 object4 = new Object4();

    public String doSomethingElse(String param) {
        return param + " 3";
    }

    public String doSomethingElseWithObject4(String param) {
        String doSomethingNew = object4.doSomethingNew(param);
        return doSomethingNew + " 3";
    }

    public String method1(String value) {
        if (value.equals("valueTrue")) {
            return method2(value);
        }
        return method3(value);


    }

    private String method3(String value) {
        return "3 "+ value;
    }

    private String method2(String value) {
        return "2 " + value;
    }
}
