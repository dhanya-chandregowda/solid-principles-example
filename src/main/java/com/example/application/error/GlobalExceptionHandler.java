package com.example.application.error;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {



    @ExceptionHandler
    public ResponseEntity<String> handleException(Exception e) {
        log.error("An error occurred", e);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
    }

    @ExceptionHandler(ActivityNotFound.class)
    public ResponseEntity<String> handleNotFoundException(Exception e) {
        log.error("An error occurred", e);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Activity Not found");
    }


}
