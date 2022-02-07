/**
 * 
 */
package com.flipkart.business;

import com.flipkart.bean.Course;
import com.flipkart.bean.RegisteredCourses;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.GradeNotAddedException;
import com.flipkart.exception.ProfessorNotRegisteredException;
import com.flipkart.exception.StudentNotRegisteredException;

import java.sql.SQLException;
import java.util.ArrayList;

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
	public void addGrade(Integer studentID, Integer semesterID,String courseID, Integer grade) throws Exception ;

	/**
	 * @param courseID
	 * @param semesterID
	 */
	public ArrayList<RegisteredCourses> viewCourseStudents(String courseID, Integer semesterID) throws Exception ;

	/**
	 * @param instructorID
	 */
	public ArrayList<Course> viewCourseProf(int instructorID) throws Exception ;

	/**
	 * @param instructorID
	 * @param semesterID
	 * @param courseID
	 */
	public void registerCourse(int instructorID, Integer semesterID, String courseID) throws Exception ;

	/**
	 * 
	 * @param username
	 * @return
	 * @throws SQLException
	 * @throws ProfessorNotRegisteredException
	 */
	public Integer getProfessorID(String username) throws SQLException, ProfessorNotRegisteredException;

}
