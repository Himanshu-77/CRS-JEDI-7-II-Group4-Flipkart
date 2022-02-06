package com.flipkart.exception;

// Exception arises when student tries to register for an already registered course
public class CourseExistsInCartException extends Throwable {

    private final String courseId;

    public CourseExistsInCartException(String courseId) {
        this.courseId = courseId;
    }
    public String getCourseID() {
        return this.courseId;
    }

    @Override
    public String getMessage() {
        return "CourseID: " + this.courseId + " is already in the cart!";
    }
}
