package com.flipkart.exception;

//Exception arises when Professor entry is there but no Instructor ID
public class ProfessorNotRegisteredException extends Exception {
	
private Integer professorId;
	
	public ProfessorNotRegisteredException() {
		// TODO Auto-generated constructor stub
	professorId = 0;
	}
	public ProfessorNotRegisteredException(Integer professorId) {
		this.professorId=professorId;
	}
	
	public Integer getUserId() {
		return this.professorId;
	}
	
	public String getMessage() {
		return "Professor with id: " + professorId + " doesnt have proper details!";
	}
}
