package com.flipkart.exception;

// Exception arises when student registers with invalid number of Primary and Alternate courses present in cart
public class InvalidSemesterRegistration extends Throwable {

    @Override
    public String getMessage() {
        return "Invalid number of Primary and Alternate courses present in cart.";
    }
}
