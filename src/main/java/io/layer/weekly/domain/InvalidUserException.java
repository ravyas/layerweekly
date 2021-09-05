package io.layer.weekly.domain;

public class InvalidUserException extends Exception {

    public InvalidUserException(){
    }

    public InvalidUserException(String message) {
        super(message);
    }
}
