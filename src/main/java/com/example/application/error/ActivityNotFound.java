package com.example.application.error;

public class ActivityNotFound extends RuntimeException{

    public ActivityNotFound(String message) {
        super(message);
    }
}
