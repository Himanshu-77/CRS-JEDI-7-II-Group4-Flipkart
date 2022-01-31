package com.flipkart.exception;

public class InvalidSemesterException extends Exception{
    private final String username;
    public InvalidSemesterException(String username){
        this.username = username;
    }
    @Override
    public String getMessage() {
        return "Invalid Semester No. entered by "+username+ " ";
    }
}
