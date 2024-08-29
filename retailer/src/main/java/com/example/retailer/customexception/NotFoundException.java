package com.example.retailer.customexception;

public class NotFoundException extends RuntimeException {

    

public NotFoundException(String message){
    super(message);
}

}
