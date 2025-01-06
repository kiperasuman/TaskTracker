package com.deneme.taskTracker.exceptions;


public enum MessageType {

    NO_RECORD_EXIST("1001","No record exist!"),
    GENERAL_EXCEPTION("1002","A general error occured!");

    private String code;
    private String message;
    MessageType(String code,String message){
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
