package com.company;

public class NoSuchUserException extends RuntimeException {
    NoSuchUserException() {
        super("No such user exists");
    }
}
