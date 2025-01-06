package com.deneme.taskTracker.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ErrorMessage {
    private MessageType messageType;
    private String ofStatic;

    public String createErrorMessage(){
        StringBuilder builder = new StringBuilder();
        builder.append(messageType.getMessage());
        if (ofStatic!=null){
            builder.append(" : " + ofStatic);
        }
        return builder.toString();
    }
    public ErrorMessage(MessageType messageType , String ofStatic){
        this.messageType = messageType;
        this.ofStatic = ofStatic;
    }
}
