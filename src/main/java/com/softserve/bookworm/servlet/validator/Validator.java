package com.softserve.bookworm.servlet.validator;

import java.util.Objects;
import java.util.function.Predicate;

public interface Validator {
    boolean isDataValid();

    static Predicate<String> minLength(int length) {
        Predicate<String> predicate = s -> s.length() >= length;
        return predicate;
    }

    static Predicate<String> notNullOrEmpty() {
        Predicate<String> predicate = Objects::isNull;
        return predicate.or(String::isEmpty).negate();
    }
}
