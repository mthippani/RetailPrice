package com.target.retailproduct.exception;

@SuppressWarnings("serial")
public class RetailProductException extends Exception {
	
    public RetailProductException() {
        super();
    }

    public RetailProductException(String message) {
        super(message);
    }

    public RetailProductException(Throwable cause) {
        super(cause);
    }

    public RetailProductException(String message, Throwable cause) {
        super(message, cause);
    }

}
