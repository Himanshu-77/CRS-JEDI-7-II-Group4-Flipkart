package com.flipkart.exception;

// Exception arises when an invalid role is selected i.e. apart from student/professor/admin.
public class InvalidRoleException extends Exception{

    @Override
    public String getMessage(){
        return "Invalid Role selected";
    }
}
