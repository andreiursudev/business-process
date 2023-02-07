package ro.rodin.businessprocessdemoapp;

import java.util.function.BinaryOperator;

public class SimplifyName implements BinaryOperator<String> {
    @Override
    public String apply(String s, String s2) {
        return s + " " + s2;
    }
}
