package com.baeldung.ecommerce.Product.Exception;


public class ProductException extends Exception {
    private String message;

    public ProductException(String message, Throwable throwable) {
        super(message, throwable);
        this.message = message;
    }
}
