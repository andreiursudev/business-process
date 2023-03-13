package ro.rodin.businessprocessesdiagram.diagram;

import java.util.LinkedHashMap;
import java.util.Map;

public class CallMap {

    private static Map<String, MethodCall> map = new LinkedHashMap<>();

    public static Map<String, MethodCall> getMap() {
        return map;
    }
}
