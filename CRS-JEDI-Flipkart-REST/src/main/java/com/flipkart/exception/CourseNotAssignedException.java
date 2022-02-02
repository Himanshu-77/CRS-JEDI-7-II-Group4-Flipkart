/**
 * 
 */
package com.flipkart.exception;

/**
 * @author Dell
 *
 */

//Exception arises when a course is not allocated to any professor

public class CourseNotAssignedException extends Exception {
	
private String courseID;
	
	public CourseNotAssignedException() {
		// TODO Auto-generated constructor stub
	courseID = "";
	}
	
	/**
	 * @param courseID
	 */
	public CourseNotAssignedException(String courseID) {
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
		return "CourseID: " + courseID + "has not been allocated to anyone!";
	}

}
