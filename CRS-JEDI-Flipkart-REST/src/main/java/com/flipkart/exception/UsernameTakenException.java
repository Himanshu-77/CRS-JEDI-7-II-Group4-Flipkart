package com.flipkart.exception;

// Exception arises when student takes an existing username.
public class UsernameTakenException extends Exception {

    @Override
    public String getMessage() {
        return "Username already taken! Try with a different username ";
    }

}
