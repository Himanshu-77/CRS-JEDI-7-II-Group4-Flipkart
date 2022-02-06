package com.flipkart.exception;

// Exception arises when a student tries to choose a course which already has maximum allowed number of students.
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
