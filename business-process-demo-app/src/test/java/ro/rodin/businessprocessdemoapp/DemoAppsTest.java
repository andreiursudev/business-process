package ro.rodin.businessprocessdemoapp;

import org.junit.jupiter.api.Test;
import ro.rodin.businessprocessdemoapp.diagram.Diagram;
import ro.rodin.businessprocessdemoapp.diagram.Element;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DemoAppsTest {

    @Test
    void NameToJson() {
        NameToJson nameToJson = new NameToJson();

        nameToJson.toJson("Andrei", "Ursu");

        List<Element> elements = Diagram.getElements();


        assertEquals(1, elements.size());
        assertEquals("Element{input={firstName=Andrei, lastName=Ursu}, packageName='ro.rodin.businessprocessdemoapp', className='NameToJson', methodName='toJson', output={\"firstName\" : \"Andrei\", \"lastName\" : \"Ursu\"}}", elements.get(0).toString());
    }


}
