/**
 * 
 */
package com.flipkart.exception;

/**
 * @author mahak
 *
 */
public class FeesPendingException extends Exception{
	private Integer studentId;
	public FeesPendingException (Integer studentId) {
		this.studentId=studentId;
	}
	public int  getStudentId() {
		return studentId;
	}

	public String getMessage() {
		return "Fees has not been paid for Student ID : " + studentId ;
	}
}
