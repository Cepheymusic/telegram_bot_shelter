package dev.pro.shelter.controller;

import dev.pro.shelter.exception.CatNotFoundException;
import dev.pro.shelter.exception.DogNotFoundException;
import dev.pro.shelter.exception.MessageNotFoundException;
import dev.pro.shelter.exception.UsersException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;




@ControllerAdvice
public class ControllerExceptionHandler {
    Logger logger = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    @ExceptionHandler({CatNotFoundException.class, DogNotFoundException.class, MessageNotFoundException.class,
            UsersException.class})
    public ResponseEntity<String> handleShelterBotsException(RuntimeException ex) {
        logger.warn(ex.getMessage());
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception exception) {
        logger.error(String.valueOf(exception));
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Server error sorry");
    }
}
