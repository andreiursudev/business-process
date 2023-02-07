package ro.rodin.businessprocessdemoapp.diagram;

import java.util.LinkedHashMap;

public class Element {
    private LinkedHashMap<String, Object> input;
    private String packageName;
    private String className;
    private String methodName;
    private Object output;

    public Element(LinkedHashMap<String, Object> input, String packageName, String className, String methodName, Object output) {
        this.input = input;
        this.packageName = packageName;
        this.className = className;
        this.methodName = methodName;
        this.output = output;
    }

    public LinkedHashMap<String, Object> getInput() {
        return input;
    }

    public String getPackageName() {
        return packageName;
    }

    public String getClassName() {
        return className;
    }

    public String getMethodName() {
        return methodName;
    }

    public Object getOutput() {
        return output;
    }

    @Override
    public String toString() {
        return "Element{" +
                "input=" + input +
                ", packageName='" + packageName + '\'' +
                ", className='" + className + '\'' +
                ", methodName='" + methodName + '\'' +
                ", output=" + output +
                '}';
    }
}
