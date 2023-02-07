package ro.rodin.businessprocessdemoapp.diagram;

import java.util.LinkedHashMap;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Element element = (Element) o;
        return Objects.equals(input, element.input) && Objects.equals(packageName, element.packageName) && Objects.equals(className, element.className) && Objects.equals(methodName, element.methodName) && Objects.equals(output, element.output);
    }

    @Override
    public int hashCode() {
        return Objects.hash(input, packageName, className, methodName, output);
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
