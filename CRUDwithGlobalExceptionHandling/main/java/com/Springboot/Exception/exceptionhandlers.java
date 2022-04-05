package com.Springboot.Exception;

import com.Springboot.Exception.CustomException.InputException;
import com.Springboot.Exception.CustomException.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@ControllerAdvice
public class exceptionhandlers extends ResponseEntityExceptionHandler
{
    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<Object> handleServiceException(ServiceException e)
    {
      ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND,"404",
              e.getMessage(), LocalDateTime.now(ZoneOffset.UTC));
      return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InputException.class)
    public ResponseEntity<Object> handleInputException(InputException e)
    {
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST,"401",
                e.getMessage(), LocalDateTime.now(ZoneOffset.UTC));
        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<Object> handleNullPointerException(NullPointerException e)
    {
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST,"401",
               "NullPointerException", LocalDateTime.now(ZoneOffset.UTC));
        return new ResponseEntity<>(errorResponse,HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<Object> handleIllegalStateException(IllegalStateException e)
    {
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_GATEWAY,"405",
                e.getMessage(), LocalDateTime.now(ZoneOffset.UTC));
        return new ResponseEntity<>(errorResponse,HttpStatus.FORBIDDEN);
    }

}
