package com.flipkart.exception;

public class InvalidRoleException extends Exception{

    @Override
    public String getMessage(){
        return "Invalid Role selected";
    }
}
