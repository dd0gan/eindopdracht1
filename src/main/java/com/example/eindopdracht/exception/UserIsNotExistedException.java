package com.example.eindopdracht.exception;

public class UserIsNotExistedException extends RuntimeException {

    public UserIsNotExistedException(String message) {
        super(message);
    }
}
