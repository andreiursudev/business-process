package ro.rodin.businessprocessdemoapp.diagram;

import java.util.ArrayList;
import java.util.List;

public class Diagram {

    public static List<Element> elements = new ArrayList<>();

    public static List<Element> getElements() {
        return elements;
    }

    public static void addElement(Element element) {
        elements.add(element);
    }
}


