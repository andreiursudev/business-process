package ro.rodin.businessprocessdemoapp;

import java.util.function.Predicate;

public class IsEmpty implements Predicate<String> {

    @Override
    public boolean test(String s) {
        return s.isEmpty();
    }
}
