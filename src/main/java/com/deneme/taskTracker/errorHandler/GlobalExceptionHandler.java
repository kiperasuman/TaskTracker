package com.deneme.taskTracker.errorHandler;
import com.deneme.taskTracker.exceptions.BaseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {BaseException.class})
    public ResponseEntity<ApiError> baseExceptionHandler(BaseException baseException, WebRequest request){
        return ResponseEntity.badRequest().body(handleApiError(baseException.getMessage(),request));
    }

    private <T> ApiError<T> handleApiError(T message, WebRequest request){
        ApiError<T> apiError = new ApiError<>();
        apiError.setStatusCode(HttpStatus.BAD_REQUEST.value());
        CustomException<T> exception = new CustomException<>();
        exception.setCreateTime(new Date());
        exception.setPath(request.getDescription(false).substring(5));
        exception.setMessage(message);
        apiError.setException(exception);
        return apiError;
    }

}
