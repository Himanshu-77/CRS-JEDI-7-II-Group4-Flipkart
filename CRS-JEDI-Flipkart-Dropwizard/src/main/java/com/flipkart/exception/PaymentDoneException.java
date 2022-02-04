package com.flipkart.exception;

public class PaymentDoneException extends Exception {

    public String getMessage() {
        return "Payment already done!! ";
    }

}
