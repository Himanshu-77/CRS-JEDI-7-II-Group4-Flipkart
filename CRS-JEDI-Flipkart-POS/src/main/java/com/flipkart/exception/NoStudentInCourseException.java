/**
 * 
 */
package com.flipkart.exception;

/**
 * @author Dell
 *
 */
public class NoStudentInCourseException extends Exception{

// Exception arises when there is no student in a course
private String courseID;
	
	public NoStudentInCourseException() {
		// TODO Auto-generated constructor stub
	
		courseID = "";
	}
	
	/**
	 * @param courseID
	 */
	public NoStudentInCourseException(String courseID) {
		super();
		this.courseID = courseID;
	}


	
	/**
	 * @return the courseID
	 */
	public String getCourseID() {
		return courseID;
	}
	
	@Override
	public String getMessage() {
		return "No student in CourseID: " + courseID + "!";
	}

}
