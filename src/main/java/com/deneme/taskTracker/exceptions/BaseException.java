package com.deneme.taskTracker.exceptions;

import lombok.NoArgsConstructor;

public class BaseException extends RuntimeException{

    public BaseException(ErrorMessage errorMessage){
        super(errorMessage.createErrorMessage());
    }
    public BaseException(){

    }
}
