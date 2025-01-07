package com.deneme.taskTracker.errorHandler;
import java.util.Date;

public class CustomException<T> {
    private String path;
    private Date createTime;
    private T message;

    public void setPath(String path) {
        this.path = path;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setMessage(T message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public T getMessage() {
        return message;
    }
}
