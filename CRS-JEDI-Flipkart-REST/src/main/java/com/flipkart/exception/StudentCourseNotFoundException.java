/**
 * 
 */
package com.flipkart.exception;

/**
 * @author Dell
 *
 */
public class StudentCourseNotFoundException extends Exception{

	Integer studentID, semesterId;
	
	/**
	 * @param studentID
	 * @param semesterId
	 */
	public StudentCourseNotFoundException(Integer studentID, Integer semesterId) {
		super();
		this.studentID = studentID;
		this.semesterId = semesterId;
	}

	public String getMessage() {
		return "No course associated with student ID="+studentID+" was found in semester "+semesterId;
	}
}
