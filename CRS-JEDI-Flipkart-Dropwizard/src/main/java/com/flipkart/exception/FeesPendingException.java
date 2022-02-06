/**
 * 
 */
package com.flipkart.exception;

/**
 * @author Aeron
 * Exception arises when fees not paid by a student but an activity occures which required fees to be paid.
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
