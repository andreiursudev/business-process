package ro.rodin.businessprocessdemoapp;

import ro.rodin.businessprocessdemoapp.diagram.GlobalDiagram;
import ro.rodin.businessprocessdemoapp.logic.Object1;

public class StartApp {
    public static void main(String[] args) {
        Object1 methods = new Object1();
        String result = methods.simpleMethod("Andrei");
        System.out.println("result= " + result);
        System.out.println(GlobalDiagram.getDiagram());
    }
}
