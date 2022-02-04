package com.flipkart.exception;


// exception when prof is not able to register for an existing course
public class ProfessorCourseRegistrationException extends Exception{

	Integer  instructorID, semesterID;
	String courseID;
	
	/**
	 * @param instructorID
	 * @param semesterID
	 * @param courseID
	 */
	public ProfessorCourseRegistrationException(Integer instructorID, Integer semesterID, String courseID) {
		super();
		this.instructorID = instructorID;
		this.semesterID = semesterID;
		this.courseID = courseID;
	}

	
	public ProfessorCourseRegistrationException() {
		instructorID = 0;
		semesterID = 1;
		courseID = "";
	}
	
	
	
	public String getMessage() {
		return "Professor with id: " + instructorID + "is not able to register for course ID = "+courseID + "in semester "+semesterID;
	}
}
