/**
 * 
 */
package com.flipkart.business;

import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.ProfessorNotRegisteredException;

import java.sql.SQLException;

/**
 * @author Aeron
 *
 */
public interface ProfessorInterface {
	
	/**
	 * Add grade for a student in a course.
	 * @param studentID
	 * @param courseID
	 * @param grade
	 */
	void addGrade(Integer studentID, Integer semesterID,String courseID, Integer grade) ;

	/**
	 * View students enrolled in a course.
	 * @param courseID
	 * @param semesterID
	 */
	void viewCourseStudents(String courseID, Integer semesterID) ;

	/**
	 * View list of courses in with professor is associated.
	 * @param instructorID
	 */
	void viewCourseProf(int instructorID) ;

	/**
	 * Professor opt-in for a course.
	 * @param instructorID
	 * @param semesterID
	 * @param courseID
	 */
	void registerCourse(int instructorID, Integer semesterID, String courseID) ;

	/**
	 * Get ID of professor by providing username.
	 * @param username
	 * @return
	 * @throws SQLException
	 * @throws ProfessorNotRegisteredException
	 */
	Integer getProfessorID(String username) throws SQLException, ProfessorNotRegisteredException;

}
