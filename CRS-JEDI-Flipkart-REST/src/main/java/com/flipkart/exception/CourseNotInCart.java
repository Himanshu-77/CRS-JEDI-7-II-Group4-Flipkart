package com.flipkart.exception;

// Exception thrown when a student tries to drop a course which is not added by him.
public class CourseNotInCart extends Throwable {
    private final String courseId;

    public CourseNotInCart(String courseId) {
        this.courseId = courseId;
    }
    public String getCourseID() {
        return this.courseId;
    }

    @Override
    public String getMessage() {
        return "CourseID: " + this.courseId + " is not present in your cart!";
    }
}
