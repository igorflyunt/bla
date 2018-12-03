package com.softserve.bookworm.servlet.validator;

import java.util.*;
import java.util.function.Predicate;

public class UserCredetialsValidtor implements Validator {
    private Map<Predicate<?>, Object> predicateValuePair = new LinkedHashMap<>();

    public UserCredetialsValidtor checkUsername(String username) {
        Predicate<String> stringPredicate = nullOrEmptyString(username);
        return this;
    }

    public UserCredetialsValidtor checkPassword(String password) {
        Predicate<String> stringPredicate = nullOrEmptyString(password);
        return this;
    }

    private Predicate<String> nullOrEmptyString(String value) {
        Predicate<String> stringPredicate = Objects::isNull;
        stringPredicate.or(String::isEmpty);
        predicateValuePair.put(stringPredicate, value);
        return stringPredicate;
    }

    @Override
    public boolean isDataValid() {
        return false;
    }
}
