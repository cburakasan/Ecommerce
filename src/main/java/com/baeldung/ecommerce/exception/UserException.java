package com.baeldung.ecommerce.exception;

import lombok.Data;

@Data
public class UserException extends Exception{
    private String message;

    public UserException(String message, Throwable throwable){
        super(message, throwable);
        this.message = message;
    }
}
