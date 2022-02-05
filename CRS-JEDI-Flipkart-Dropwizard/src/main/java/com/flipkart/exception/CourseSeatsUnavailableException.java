package com.flipkart.exception;

public class CourseSeatsUnavailableException extends Exception {

    private final String courseId;

    public CourseSeatsUnavailableException(String courseId) {
        this.courseId = courseId;
    }
    public String getCourseID() {
        return this.courseId;
    }

    @Override
    public String getMessage() {
        return "CourseID: " + this.courseId + " has no seats available!";
    }

}
