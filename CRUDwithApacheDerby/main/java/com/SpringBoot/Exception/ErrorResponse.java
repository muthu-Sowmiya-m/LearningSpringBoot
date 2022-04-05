package com.SpringBoot.Exception;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ErrorResponse {

    private HttpStatus status;
    private String error_code;
    private String message;
    private LocalDateTime timeStamp;

    public ErrorResponse(HttpStatus status, String error_code, String message,
                         LocalDateTime timeStamp)
    {
        this.status = status;
        this.error_code = error_code;
        this.message = message;
        this.timeStamp = timeStamp;
    }
   // getter and setters

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getError_code() {
        return error_code;
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }
}