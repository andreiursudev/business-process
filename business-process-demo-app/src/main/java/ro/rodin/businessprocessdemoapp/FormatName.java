package ro.rodin.businessprocessdemoapp;

import java.util.function.Function;

public class FormatName implements Function<String, String> {
    @Override
    public String apply(String s) {
        return s.toUpperCase();
    }
}
