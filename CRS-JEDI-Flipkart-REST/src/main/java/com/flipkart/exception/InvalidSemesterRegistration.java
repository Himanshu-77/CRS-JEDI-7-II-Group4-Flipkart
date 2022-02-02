package com.flipkart.exception;

public class InvalidSemesterRegistration extends Throwable {

    @Override
    public String getMessage() {
        return "Invalid number of Primary and Alternate courses present in cart.";
    }
}
