/**
 * 
 */
package com.flipkart.business;

import com.flipkart.exception.CourseNotFoundException;

/**
 * @author rutwi
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
	 * @throws CourseNotFoundException
	 */

	public void viewCourseStudents(String courseID, Integer semesterID) ;
	public void viewCourseProf(int instructorID) ;
	public void registerCourse(int instructorID, Integer semesterID, String courseID) ;
}
