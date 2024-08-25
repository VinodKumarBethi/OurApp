package com.example.demo.customexception;

public class NotFoundException extends RuntimeException {

    

public NotFoundException(String message){
    super(message);
}

}
