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
 * @author rutwi
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
	 * @param professorID
	 * @return
	 */
//	View student details for students who are registered in a particular course
	

	public ArrayList<RegisteredCourses> viewCourseStudents(String courseID, Integer semesterID) throws SQLException,NoStudentInCourseException;

	// view courses which the professor is associated with
	public ArrayList<Course> viewCourseProf(Integer instructorID) throws SQLException,ProfessorNotAssignedException;
	
//	prof registers for course if no one is allocated to it
	public Boolean registerCourse(Integer instructorID, Integer semesterID,String courseID)throws SQLException,ProfessorCourseRegistrationException;
	
	public int getProfessorIDFromUserName(String username) throws SQLException,ProfessorNotRegisteredException;
}
