package com.flipkart.exception;

// Exception arises when student tries to pay fees but payment window for that semester has not opened.
public class PaymentWindowException extends Exception{
    public String getMessage() {
        return "Payment Window not opened !!!";
    }

}
