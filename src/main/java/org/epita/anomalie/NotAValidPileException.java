package org.epita.anomalie;

public class NotAValidPileException extends RuntimeException{
    public NotAValidPileException(String message) {
        super(message);
    }
}
