package com.bosch.product.app.exception;

public class ProductValidationException extends Exception{

    public ProductValidationException() {
        super();
    }

    public ProductValidationException(String message) {
        super(message);
    }

    public ProductValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    protected ProductValidationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
