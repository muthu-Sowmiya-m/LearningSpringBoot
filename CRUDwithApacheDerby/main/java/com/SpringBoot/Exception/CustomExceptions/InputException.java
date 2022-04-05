package com.SpringBoot.Exception.CustomExceptions;

public class InputException extends RuntimeException
{
    public InputException() {
    }

    public InputException(String message) {
        super(message);
    }

    public InputException(String message, Throwable cause) {
        super(message, cause);
    }
}
