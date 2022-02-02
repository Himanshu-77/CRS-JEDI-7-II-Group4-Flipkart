/**
 * 
 */
package com.flipkart.exception;

/**
 * @author Dell
 * Exception arises when student has taken more than the recommended limit of courses
 */

public class CourseLimitExceededException extends Exception {

	private String studentID;
	
	public CourseLimitExceededException() {
		// TODO Auto-generated constructor stub
		studentID = "";
	}

	/**
	 * @param studentID
	 */
	public CourseLimitExceededException(String studentID) {
		super();
		this.studentID = studentID;
	}

	/**
	 * @return the courseID
	 */
	public String getstudentID() {
		return studentID;
	}
	
	@Override
	public String getMessage() {
		return "studentID: " + studentID + "has exceeded course Limit!";
	}
}

