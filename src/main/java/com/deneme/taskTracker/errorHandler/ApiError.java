package com.deneme.taskTracker.errorHandler;

import lombok.Getter;
import lombok.Setter;

public class ApiError<T> {
    private Integer statusCode;
    private CustomException<T> exception;

    public CustomException<T> getException() {
        return exception;
    }

    public void setException(CustomException<T> exception) {
        this.exception = exception;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }
}
