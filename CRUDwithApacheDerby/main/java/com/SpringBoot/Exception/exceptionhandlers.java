package com.SpringBoot.Exception;

import com.SpringBoot.Exception.CustomExceptions.InputException;
import com.SpringBoot.Exception.CustomExceptions.ServiceException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.NoSuchElementException;

@ControllerAdvice
public class exceptionhandlers extends ResponseEntityExceptionHandler
{
    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<Object> handleServiceException(ServiceException e)
    {
      ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST,"404",
              e.getMessage(), LocalDateTime.now(ZoneOffset.UTC));
      return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InputException.class)
    public ResponseEntity<Object> handleInputException(InputException e)
    {
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND,"404",
                e.getMessage(), LocalDateTime.now(ZoneOffset.UTC));
        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<Object> handleEmptyResultDataAccessException(EmptyResultDataAccessException e)
    {
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST,"404",
                "The id requested to delete doesn't exist!!", LocalDateTime.now(ZoneOffset.UTC));
        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({NoSuchMethodException.class,NoSuchElementException.class,IllegalArgumentException.class})
    public ResponseEntity<Object> handleNoSuchElementException(NoSuchElementException e)
    {
        return new ResponseEntity<>(e.getMessage(),HttpStatus.NO_CONTENT);
    }

}
