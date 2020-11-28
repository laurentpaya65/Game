package org.epita.anomalie;

public class NotAValidPlayException extends RuntimeException{
    public NotAValidPlayException(String message) {
        super(message);
    }
}
