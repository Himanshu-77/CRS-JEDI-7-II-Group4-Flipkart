/**
 * 
 */
package com.flipkart.exception;

/**
 * @author Dell
 *
 */

// Exception arises when student tries to register for an already registered course

public class CourseAlreadyRegisteredException extends Exception{

	private String courseID;
	
	public CourseAlreadyRegisteredException() {
		// TODO Auto-generated constructor stub
	courseID = "";
	}
	
	/**
	 * @param courseID
	 */
	public CourseAlreadyRegisteredException(String courseID) {
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
		return "CourseID: " + courseID + "is already registered!";
	}
}
