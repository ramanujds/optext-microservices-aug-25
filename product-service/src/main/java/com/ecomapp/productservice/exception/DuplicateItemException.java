package com.ecomapp.productservice.exception;

public class DuplicateItemException extends RuntimeException{

    public DuplicateItemException(String message) {
        super(message);
    }
}
