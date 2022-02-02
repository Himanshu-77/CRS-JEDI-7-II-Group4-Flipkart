/**
 * 
 */
package com.flipkart.dao;

import com.flipkart.bean.Course;
import com.flipkart.bean.RegisteredCourses;
import com.flipkart.exception.*;

import java.sql.SQLException;
import java.util.ArrayList;


/**
 * @author Aeron
 *
 */
public interface ProfessorDaoInterface {
	
	/**
	 * @param studentID
	 * @param courseID
	 * @param grade
	 */
	public void addGrade(Integer studentID, Integer semesterID,String courseID, Integer grade) throws SQLException, GradeNotAddedException,StudentNotRegisteredException;


	/**
	 * View student details for students who are registered in a particular course
	 * @param courseID
	 * @param semesterID
	 * @return
	 * @throws SQLException
	 * @throws NoStudentInCourseException
	 */
	public ArrayList<RegisteredCourses> viewCourseStudents(String courseID, Integer semesterID) throws SQLException,NoStudentInCourseException;

	/**
	 * View courses which the professor is associated with
	 * @param instructorID
	 * @return
	 * @throws SQLException
	 * @throws ProfessorNotAssignedException
	 */
	public ArrayList<Course> viewCourseProf(Integer instructorID) throws SQLException,ProfessorNotAssignedException;

	/**
	 * Prof. registers for course if no one is allocated to it
	 * @param instructorID
	 * @param semesterID
	 * @param courseID
	 * @return
	 * @throws SQLException
	 * @throws ProfessorCourseRegistrationException
	 */
	public Boolean registerCourse(Integer instructorID, Integer semesterID,String courseID)throws SQLException,ProfessorCourseRegistrationException;

	/**
	 * @param username
	 * @return
	 * @throws SQLException
	 * @throws ProfessorNotRegisteredException
	 */
	public int getProfessorIDFromUserName(String username) throws SQLException,ProfessorNotRegisteredException;
}
