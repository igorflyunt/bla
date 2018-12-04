package com.softserve.bookworm.servlet.validator;

import java.util.Objects;
import java.util.function.Predicate;

public interface Validator {
    boolean isDataValid();

    static Predicate<String> minLength(int length) {
        return s -> s.length() >= length;
    }

    static Predicate<String> notNullOrEmpty() {
        Predicate<String> predicate = Objects::isNull;
        return predicate.or(String::isEmpty).negate();
    }

    static Predicate<String> notNull() {
        Predicate<String> predicate = Objects::isNull;
        return predicate.negate();

    }
}