package dev.pro.shelter.exception;

public class MessageNotFoundException extends RuntimeException{
    public MessageNotFoundException(String message) {
        super(message);
    }
}
