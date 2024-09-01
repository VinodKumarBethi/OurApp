package com.gateway.gateway.customException;

public class GateWayError {

    private GateWayException error;

    public GateWayError(GateWayException error) {
        this.error = error;
    }
    
}