package ro.rodin.businessprocessdemoapp;

import ro.rodin.businessprocessdemoapp.logic.NameToJson;

public class StartApp {
    public static void main(String[] args) {
        NameToJson nameToJson = new NameToJson();
        String result = nameToJson.toJson("Andrei", "Ursu");
        System.out.println("result= " + result);
    }
}
