package com.adobe.aem.romanconverter.controller.advice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * The controller advice class that handles invalid argument exceptions thrown by controllers.
 */
@ControllerAdvice
@Slf4j
public class InvalidArgumentAdvice {

    /**
     * This method takes a IllegalArgumentException and respond with 400 and exception message.
     * @param exception {@link IllegalArgumentException}
     * @return {@link ResponseEntity<String>}
     */
    @ExceptionHandler(value = IllegalArgumentException.class)
    ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException exception) {
        log.warn("IllegalArgumentException thrown by a controller.", exception);
        return new ResponseEntity<String>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    /**
     * This method takes a MissingServletRequestParameterException and respond with 400 and exception message.
     * @param exception {@link MissingServletRequestParameterException}
     * @return {@link ResponseEntity<String>}
     */
    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    ResponseEntity<String> handleMissingParamException(MissingServletRequestParameterException exception) {
        log.warn("MissingServletRequestParameterException thrown by a controller.", exception);
        return new ResponseEntity<String>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
