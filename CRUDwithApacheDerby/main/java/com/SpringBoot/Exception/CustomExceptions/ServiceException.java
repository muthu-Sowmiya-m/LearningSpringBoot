package com.SpringBoot.Exception.CustomExceptions;

public class ServiceException extends RuntimeException
{
    public ServiceException(String message) {
        super(message);
    }

    public ServiceException() {
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
