package ro.rodin.businessprocessdemoapp.diagram;

import java.util.List;
import java.util.Objects;

public class Method {
     private String methodName;
     List<Method> children;

     public Method(String methodName) {
          this.methodName = methodName;
     }

     @Override
     public boolean equals(Object o) {
          if (this == o) return true;
          if (o == null || getClass() != o.getClass()) return false;
          Method method = (Method) o;
          return Objects.equals(methodName, method.methodName) && Objects.equals(children, method.children);
     }

     @Override
     public int hashCode() {
          return Objects.hash(methodName, children);
     }

     @Override
     public String toString() {
          return "Method{" +
                  "methodName='" + methodName + '\'' +
                  ", children=" + children +
                  '}';
     }
}
