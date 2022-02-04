package com.flipkart.exception;

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
