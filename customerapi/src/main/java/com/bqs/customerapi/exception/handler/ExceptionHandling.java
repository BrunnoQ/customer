package com.bqs.customerapi.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.bqs.customerapi.exception.BusinessException;
import com.bqs.customerapi.exception.handler.message.ErrorMessage;
import jakarta.persistence.EntityNotFoundException;

/**
 * This class handles exceptions thrown by the Customer API.
 */
public class ExceptionHandling extends ResponseEntityExceptionHandler {

    /**
     * Handles the EntityNotFoundException and returns a ResponseEntity with an error message.
     * 
     * @param ex The EntityNotFoundException that was thrown
     * @return A ResponseEntity containing the error message and HTTP status code
     */
    @ExceptionHandler(value = { EntityNotFoundException.class })
    public ResponseEntity<ErrorMessage> handleEntityNotFoundException(EntityNotFoundException ex) {
        var apiError = ErrorMessage.builder()
                .code(HttpStatus.NOT_FOUND.value())
                .message(ex.getMessage())
                .detail(ex.getLocalizedMessage())
                .build();
        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }

    /**
     * Handles IllegalArgumentException and returns a ResponseEntity with an ErrorMessage object.
     * 
     * @param ex The IllegalArgumentException that was thrown
     * @return A ResponseEntity containing the ErrorMessage object and HttpStatus.BAD_REQUEST
     */
    @ExceptionHandler(value = { IllegalArgumentException.class })
    public ResponseEntity<ErrorMessage> handleIllegalArgumentException(IllegalArgumentException ex) {
        var apiError = ErrorMessage.builder()
                .code(HttpStatus.BAD_REQUEST.value())
                .message(ex.getMessage())
                .detail(ex.getLocalizedMessage())
                .build();
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }

    /**
     * Handles exceptions of type Exception and returns an appropriate ResponseEntity with an ErrorMessage.
     * 
     * @param ex The exception to be handled.
     * @return A ResponseEntity containing an ErrorMessage and the HTTP status code.
     */
    @ExceptionHandler(value = { Exception.class })
    public ResponseEntity<ErrorMessage> handleException(Exception ex) {
        var apiError = ErrorMessage.builder()
                .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message(ex.getMessage())
                .detail(ex.getLocalizedMessage())
                .build();
        return new ResponseEntity<>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Handles the BusinessException and returns an appropriate error response.
     *
     * @param ex The BusinessException that occurred.
     * @return A ResponseEntity containing the error message and HTTP status code.
     */
    @ExceptionHandler(value = { BusinessException.class })
    public ResponseEntity<ErrorMessage> handleBusinessException(BusinessException ex) {
        var apiError = ErrorMessage.builder()
                .code(HttpStatus.BAD_REQUEST.value())
                .message(ex.getMessage())
                .detail(ex.getLocalizedMessage())
                .build();
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }

}