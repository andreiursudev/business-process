package ro.rodin.businessprocessdemoapp;

import ro.rodin.businessprocessdemoapp.logic.Methods;

public class StartApp {
    public static void main(String[] args) {
        Methods methods = new Methods();
        String result = methods.returnTypeTwoParameter("Andrei", "Ursu");
        System.out.println("result= " + result);
    }
}
