package com.gateway.gateway.customException;

public class GateWayException extends RuntimeException {
    private int statusCode;
    private String message;

    public GateWayException(int statusCode, String message) {
        super(message);
        this.statusCode = statusCode;
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }
}