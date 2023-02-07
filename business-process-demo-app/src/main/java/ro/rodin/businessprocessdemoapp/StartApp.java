package ro.rodin.businessprocessdemoapp;

public class StartApp {
    public static void main(String[] args) {
        NameToJson nameToJson = new NameToJson();
        String result = nameToJson.toJson("Andrei", "Ursu");
        System.out.println("result= " + result);
    }
}
