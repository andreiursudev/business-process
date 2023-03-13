package ro.rodin.businessprocessesdiagram.diagram;

import java.util.LinkedHashMap;
import java.util.Map;

public class CallMap {

    private static Map<String, MethodExecution> map = new LinkedHashMap<>();

    public static Map<String, MethodExecution> getMap() {
        return map;
    }

    public static void clear(){
        getMap().clear();
    }
}
