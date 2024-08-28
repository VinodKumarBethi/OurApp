package com.example.app.customexception;

public class NotFoundException extends RuntimeException {

    

public NotFoundException(String message){
    super(message);
}

}
