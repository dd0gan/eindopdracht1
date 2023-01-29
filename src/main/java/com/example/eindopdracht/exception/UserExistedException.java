package com.example.eindopdracht.exception;

public class UserExistedException extends RuntimeException {

    public UserExistedException(String message) {
        super(message);
    }
}
