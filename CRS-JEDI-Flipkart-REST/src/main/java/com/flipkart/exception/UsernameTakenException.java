package com.flipkart.exception;

public class UsernameTakenException extends Exception {

    @Override
    public String getMessage() {
        return "Username already taken! Try with a different username ";
    }

}
