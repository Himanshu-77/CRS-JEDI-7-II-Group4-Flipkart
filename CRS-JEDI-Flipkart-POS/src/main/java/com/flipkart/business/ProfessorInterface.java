/**
 * 
 */
package com.flipkart.business;

import com.flipkart.exception.CourseNotFoundException;

/**
 * @author Aeron
 *
 */
public interface ProfessorInterface {
	
	/**
	 * @param studentID
	 * @param courseID
	 * @param grade
	 */
	public void addGrade(Integer studentID, Integer semesterID,String courseID, Integer grade) ;

	/**
	 * @param courseID
	 * @param semesterID
	 */
	public void viewCourseStudents(String courseID, Integer semesterID) ;

	/**
	 * @param instructorID
	 */
	public void viewCourseProf(int instructorID) ;

	/**
	 * @param instructorID
	 * @param semesterID
	 * @param courseID
	 */
	public void registerCourse(int instructorID, Integer semesterID, String courseID) ;
}
