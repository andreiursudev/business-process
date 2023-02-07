package ro.rodin.businessprocessdemoapp;

public class NameToJson {
    public String toJson(String firstName, String lastName) {
        return String.format("{\"firstName\" : \"%s\", \"lastName\" : \"%s\"}", firstName, lastName);
    }
}
