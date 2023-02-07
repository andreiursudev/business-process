package ro.rodin.businessprocessdemoapp.logic;

public class Methods {
    public void voidNoParameter() {
        System.out.println("voidNoParameter");
    }

    public void voidAndOneParameter(String firstParameter) {
        System.out.println(firstParameter);
    }

    public void voidAndTwoParametersMethod(String firstParameter, String secondParameter) {
        System.out.println(firstParameter + secondParameter);
    }

    public String returnTypeNoParameter() {
        return "stringParam";
    }

    public String returnTypeOneParameter(String firstParameter) {
        return firstParameter + "Result";
    }

    public String returnTypeTwoParameter(String firstParameter, String secondParameter) {
        return firstParameter + secondParameter;
    }
}
