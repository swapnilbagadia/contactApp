package com.test.contactapp.exceptions;

/**
 * @author Swapnil Bagadia
 */
public class UnAuthenticatedException extends RuntimeException {

    public UnAuthenticatedException(String message) {
        super(message);
    }
}
