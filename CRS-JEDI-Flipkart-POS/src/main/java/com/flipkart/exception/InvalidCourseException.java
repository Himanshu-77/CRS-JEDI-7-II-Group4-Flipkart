/**
 * 
 */
package com.flipkart.exception;

/**
 * @author Dell
 *
 */

//Exception arises when course has number of students which are either more/less than the recommended range
public class InvalidCourseException extends Exception {

	private String courseID;
	private int numberOfStudents;
	
	public InvalidCourseException() {
		// TODO Auto-generated constructor stub
	courseID = "";
	numberOfStudents = 0;
	}
	
	/**
	 * @param courseID
	 * @param numberOfStudents
	 */
	public InvalidCourseException(String courseID, int numberOfStudents) {
		super();
		this.courseID = courseID;
		this.numberOfStudents = numberOfStudents;
	}

	/**
	 * @param courseID
	 */

	
	/**
	 * @return the courseID
	 */
	public String getCourseID() {
		return courseID;
	}
	
	@Override
	public String getMessage() {
		return "CourseID: " + courseID + "already has " + numberOfStudents + " number of students!";
	}
}
