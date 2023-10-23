package com.example.mygestion.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ControllerUtil {

    public static ResponseEntity<SuccessResponse> returnSuccess(Object obj, String message, HttpStatus status) {
        return new ResponseEntity<>(new SuccessResponse(obj, status.value(), message), status);
    }

    public static ResponseEntity<ErrorDisplay> returnError(Exception obj, HttpStatus status) {
        return new ResponseEntity<>(new ErrorDisplay(status, obj), status);
    }

}

