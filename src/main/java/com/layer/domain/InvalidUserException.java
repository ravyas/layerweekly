package com.layer.domain;

public class InvalidUserException extends Exception {

    public InvalidUserException(){
    }

    public InvalidUserException(String message) {
        super(message);
    }
}
