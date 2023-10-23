package com.example.mygestion.utils;

public class SuccessResponse {
    private int status;
    private String message;
    private Object data;

    public SuccessResponse(Object data, int status, String message) {
        this.data = data;
        this.status = status;
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getStatus(){
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
