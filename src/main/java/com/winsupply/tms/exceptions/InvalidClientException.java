package com.winsupply.tms.exceptions;

public class InvalidClientException extends Exception {
    public InvalidClientException() {
        super("Client name is invalid.");
    }

    public InvalidClientException(String message) {
        super(message);
    }
}
