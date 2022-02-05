package com.flipkart.exception;


// when professor is not assigned to any course
public class ProfessorNotAssignedException extends Exception {

	private Integer professorId;
	
	public ProfessorNotAssignedException() {
		// TODO Auto-generated constructor stub
	professorId = 0;
	}
	public ProfessorNotAssignedException(Integer professorId) {
		this.professorId=professorId;
	}
	
	public Integer getUserId() {
		return this.professorId;
	}
	
	public String getMessage() {
		return "Professor with id: " + professorId + " is not associated with any course!";
	}
}
