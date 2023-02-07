package ro.rodin.businessprocessdemoapp;

import org.junit.jupiter.api.Test;
import ro.rodin.businessprocessdemoapp.diagram.Diagram;
import ro.rodin.businessprocessdemoapp.diagram.Element;
import ro.rodin.businessprocessdemoapp.logic.Methods;
import ro.rodin.businessprocessdemoapp.logic.NameToJson;

import java.util.LinkedHashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DemoAppsTest {

    @Test
    void voidNoParameterMethodToElement() {
        Methods methods = new Methods();

        methods.voidNoParameter();

        assertEquals(new Element(new LinkedHashMap<>(),
                "ro.rodin.businessprocessdemoapp.logic",
                "Methods",
                "voidNoParameter",
                null), Diagram.getLastElement());
    }

    @Test
    void NameToJson() {
        NameToJson nameToJson = new NameToJson();

        nameToJson.toJson("Andrei", "Ursu");

        List<Element> elements = Diagram.getElements();

        LinkedHashMap<String, Object> parameters = new LinkedHashMap<>();
        parameters.put("firstName", "Andrei");
        parameters.put("lastName", "Ursu");
        assertEquals(new Element(parameters,
                "ro.rodin.businessprocessdemoapp.logic",
                "NameToJson",
                "toJson",
                "{\"firstName\" : \"Andrei\", \"lastName\" : \"Ursu\"}"), Diagram.getLastElement());
    }


}
