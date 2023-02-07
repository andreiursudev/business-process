package ro.rodin.businessprocessdemoapp;

public class MultiEndFlow {
    private PersistName persistName;
    private NameToJson nameToJson;

    public MultiEndFlow(PersistName persistName, NameToJson nameToJson) {
        this.persistName = persistName;
        this.nameToJson = nameToJson;
    }

    public String process(String firstName, String lastName) {
        persistName.persist(firstName, lastName);
        return nameToJson.toJson(firstName, lastName);
    }
}
