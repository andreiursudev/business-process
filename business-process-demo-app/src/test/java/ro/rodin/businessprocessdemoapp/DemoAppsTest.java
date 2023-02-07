package ro.rodin.businessprocessdemoapp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DemoAppsTest {

    @Test
    void NameToJson() {
        NameToJson nameToJson = new NameToJson();

        Object toJson = nameToJson.toJson("Andrei", "Ursu");


        assertEquals("{\"firstName\" : \"Andrei\", \"lastName\" : \"Ursu\"}", toJson);
    }


}
