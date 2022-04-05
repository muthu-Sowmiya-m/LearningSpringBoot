package com.Springboot.Exception.CustomException;

public class InputException extends RuntimeException
{
    public InputException() {
    }

    public InputException(String message, Throwable cause) {
        super(message, cause);
    }

    public InputException(String message) {
        super(message);
    }
}
