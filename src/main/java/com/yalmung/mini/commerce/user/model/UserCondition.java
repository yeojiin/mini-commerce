package com.yalmung.mini.commerce.user.model;

import java.util.function.Predicate;

@FunctionalInterface
public interface UserCondition {
    Predicate<User> chekUser(String field, String value, String operator);
}
