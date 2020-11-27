package org.epita.anomalie;

public class UnavailableCardException extends RuntimeException {
    public UnavailableCardException(String message) {
        super(message);
    }
}
