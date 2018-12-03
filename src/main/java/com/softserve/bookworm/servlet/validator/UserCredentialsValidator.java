package com.softserve.bookworm.servlet.validator;

import java.util.*;
import java.util.function.Predicate;

public class UserCredentialsValidator implements Validator {
    private static final String PASSWORD_PATTERN = "some regexp";

    private static final int PASSWORD_MIN_LENGTH = 4;
    private static final int USERNAME_MIN_LENGTH = 2;

    private Map<Predicate<String>, String> predicateValuePair = new LinkedHashMap<>();

    public UserCredentialsValidator checkFirstName(String firstName) {
        predicateValuePair.put(Validator.notNullOrEmpty(), firstName);
        return this;
    }

    public UserCredentialsValidator checkLastName(String lastName) {
        predicateValuePair.put(Validator.notNullOrEmpty(), lastName);
        return this;
    }

    public UserCredentialsValidator checkUsername(String username) {
        Predicate<String> stringPredicate = Validator.notNullOrEmpty().and(Validator.minLength(USERNAME_MIN_LENGTH));
        predicateValuePair.put(stringPredicate, username);
        return this;
    }

    public UserCredentialsValidator checkPassword(String password) {
        Predicate<String> stringPredicate = Validator.notNullOrEmpty().and(Validator.minLength(PASSWORD_MIN_LENGTH))
                .and(s -> s.matches(PASSWORD_PATTERN));
        predicateValuePair.put(stringPredicate, password);
        return this;
    }

    public UserCredentialsValidator comparePasswords(String storedPassword, String loginPassword) {
        Predicate<String> predicate = Validator.notNullOrEmpty().and(Predicate.isEqual(loginPassword));
        predicateValuePair.put(predicate, storedPassword);
        return this;
    }

    @Override
    public boolean isDataValid() {
        for (Map.Entry<Predicate<String>, String> predicatePair : predicateValuePair.entrySet()) {
            boolean dataIsNotValid = !predicatePair.getKey().test(predicatePair.getValue());
            if (dataIsNotValid)
                return false; }
        return true;
    }
}
