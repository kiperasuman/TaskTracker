package com.deneme.taskTracker.errorHandler;

import com.deneme.taskTracker.exceptions.BaseException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice

public class GlobalExceptionHandler {

    @ExceptionHandler(value = {BaseException.class})
    public ResponseEntity<String> catchBaseExceptionHandler(BaseException baseException){
        return ResponseEntity.badRequest().body(baseException.getMessage());
    }

}
