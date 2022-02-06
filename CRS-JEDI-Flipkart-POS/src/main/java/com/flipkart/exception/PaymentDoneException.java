package com.flipkart.exception;

// Exception arises when student tries to pay fees / finish registration after payment is done.
public class PaymentDoneException extends Exception {

    public String getMessage() {
        return "Payment already done!! ";
    }

}
