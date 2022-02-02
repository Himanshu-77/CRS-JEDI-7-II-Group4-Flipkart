/**
 * 
 */
package com.flipkart.exception;

/**
 * @author Aeron
 *
 */

public class GradeNotAddedException extends Exception {
	private Integer studentId;
	public GradeNotAddedException (Integer studentId) {
		this.studentId=studentId;
	}
	public int  getStudentId() {
		return studentId;
	}

	@Override
	public String getMessage() {
		return "Grades have not been added for Student ID : " + studentId ;
	}

}
