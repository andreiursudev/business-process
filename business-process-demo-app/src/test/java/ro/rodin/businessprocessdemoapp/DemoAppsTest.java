package ro.rodin.businessprocessdemoapp;

import org.junit.jupiter.api.Test;
import ro.rodin.businessprocessdemoapp.diagram.Diagram;
import ro.rodin.businessprocessdemoapp.diagram.Element;
import ro.rodin.businessprocessdemoapp.logic.Methods;

import java.util.LinkedHashMap;

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
    void voidAndOneParameterMethodToElement() {
        Methods methods = new Methods();

        methods.voidAndOneParameter("parameterValue");

        LinkedHashMap<String, Object> parameters = new LinkedHashMap<>();
        parameters.put("firstParameter", "parameterValue");
        assertEquals(new Element(parameters,
                "ro.rodin.businessprocessdemoapp.logic",
                "Methods",
                "voidAndOneParameter",
                null), Diagram.getLastElement());
    }

    @Test
    void voidAndTwoParametersMethodToElement() {
        Methods methods = new Methods();

        methods.voidAndTwoParametersMethod("firstParameterValue", "secondParameterValue");

        LinkedHashMap<String, Object> parameters = new LinkedHashMap<>();
        parameters.put("firstParameter", "firstParameterValue");
        parameters.put("secondParameter", "secondParameterValue");
        assertEquals(new Element(parameters,
                "ro.rodin.businessprocessdemoapp.logic",
                "Methods",
                "voidAndTwoParametersMethod",
                null), Diagram.getLastElement());
    }

    @Test
    void returnTypeNoParameterMethodToElement() {
        Methods methods = new Methods();

        String result = methods.returnTypeNoParameter();

        assertEquals(new Element(new LinkedHashMap<>(),
                "ro.rodin.businessprocessdemoapp.logic",
                "Methods",
                "returnTypeNoParameter",
                result), Diagram.getLastElement());
    }

    @Test
    void returnTypeOneParameterMethodToElement() {
        Methods methods = new Methods();

        String result = methods.returnTypeOneParameter("parameterValue");

        LinkedHashMap<String, Object> parameters = new LinkedHashMap<>();
        parameters.put("firstParameter", "parameterValue");
        assertEquals(new Element(parameters,
                "ro.rodin.businessprocessdemoapp.logic",
                "Methods",
                "returnTypeOneParameter",
                result), Diagram.getLastElement());
    }

    @Test
    void returnTypeTwoParameterMethodToElement() {
        Methods methods = new Methods();

        String result = methods.returnTypeTwoParameter("firstParameterValue", "secondParameterValue");

        LinkedHashMap<String, Object> parameters = new LinkedHashMap<>();
        parameters.put("firstParameter", "firstParameterValue");
        parameters.put("secondParameter", "secondParameterValue");
        assertEquals(new Element(parameters,
                "ro.rodin.businessprocessdemoapp.logic",
                "Methods",
                "returnTypeTwoParameter",
                result), Diagram.getLastElement());
    }

}
