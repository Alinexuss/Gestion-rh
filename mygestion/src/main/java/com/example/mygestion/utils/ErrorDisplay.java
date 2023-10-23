package com.example.mygestion.utils;

import org.springframework.http.HttpStatus;

public class ErrorDisplay {

    private Integer code;
    private String message;

    public ErrorDisplay() {
    }

    public ErrorDisplay(HttpStatus code, String message) {
        this.code = code.value();
        this.message = message;
    }

    public ErrorDisplay(HttpStatus code, Exception e) {
        this.code = code.value();
        this.message = e.getMessage();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

