/**
 * 
 */
package com.flipkart.exception;

/**
 * @author Dell
 *
 */

//Exception arises when course doesnt exist in the course catalog

public class CourseNotFoundException extends Exception {
	private String courseID;
	
	public CourseNotFoundException() {
		// TODO Auto-generated constructor stub
	courseID = "";
	}
	
	/**
	 * @param courseID
	 */
	public CourseNotFoundException(String courseID) {
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
		return "CourseID: " + courseID + " is not present in course catalogue!";
	}

}
