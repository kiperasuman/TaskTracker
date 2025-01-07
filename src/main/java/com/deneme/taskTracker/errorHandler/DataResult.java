package com.deneme.taskTracker.errorHandler;

public class DataResult<T> {
    private boolean success;
    private String errorMessage;
    private T data;

    public DataResult(T data, boolean success){
        this.data= data;
        this.success= success;
    }
    public DataResult(boolean success,String errorMessage){
        this.success = success;
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
