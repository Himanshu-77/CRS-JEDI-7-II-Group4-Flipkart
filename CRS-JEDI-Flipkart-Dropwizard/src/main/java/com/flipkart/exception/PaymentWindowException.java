package com.flipkart.exception;

public class PaymentWindowException extends Exception{
    public String getMessage() {
        return "Payment Window not opened !!!";
    }

}
