package com.flipkart.exception;

// Exception arises when an invalid semester number is entered.
public class InvalidSemesterException extends Exception{


    @Override
    public String getMessage() {
        return "Invalid Semester No. entered ";
    }
}