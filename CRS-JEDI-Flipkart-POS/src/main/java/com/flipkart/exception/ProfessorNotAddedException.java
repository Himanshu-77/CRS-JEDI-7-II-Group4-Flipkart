/**
 * 
 */
package com.flipkart.exception;

/**
 * @author JEDI-G6
 *
 */

// Professor is not added to Course Catalogue
public class ProfessorNotAddedException extends Exception{
	private String professorId;
	
	public ProfessorNotAddedException() {
		// TODO Auto-generated constructor stub
	professorId = "";
	}

	public ProfessorNotAddedException(String professorId) {
		this.professorId=professorId;
	}
	
	public String getUserId() {
		return this.professorId;
	}
	
	public String getMessage() {
		return "Professor with id: " + professorId + "is not added yet!";
	}

}
