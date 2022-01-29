/**
 * 
 */
package com.flipkart.exception;

/**
 * @author Dell
 *
 */

//Exception arises when the report card for a student ID doesnt exist

public class ReportCardNotFoundException extends Exception{
	
private String studentID;
	
	public ReportCardNotFoundException() {
		// TODO Auto-generated constructor stub
	
		studentID = "";
	
	}
	
	
	/**
	 * @param courseID
	 */
	public ReportCardNotFoundException(String studentID) {
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
		return "Report Card for studentID: " + studentID + "not found!";
	}

}
