package com.flipkart.exception;

public class InvalidSemesterException extends Exception{


    @Override
    public String getMessage() {
        return "Invalid Semester No. entered ";
    }
}