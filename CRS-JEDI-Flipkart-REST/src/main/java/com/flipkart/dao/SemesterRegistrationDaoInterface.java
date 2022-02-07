/**
 * 
 */
package com.flipkart.dao;

import com.flipkart.bean.Course;
import com.flipkart.exception.*;

import java.sql.SQLException;
import java.util.ArrayList;


/**
 * @author Dell
 *
 */
public interface SemesterRegistrationDaoInterface {
	
	/**
	 * Method to add Course selected by student 
	 * @param studentId
	 * @param semesterId
	 * @param courseId
	 * @return the course if it is added successfully, else null
	 */

	public boolean addCourse(int studentId, int semesterId, String courseId, boolean isPrimary) throws Exception,CourseExistsInCartException;

	
	/**
	 * Method to drop Course selected by student 
	 * @param studentId
	 * @param semesterId
	 * @param courseId 
	 * @return Boolean value indicating if it is was dropped successfully
	 */
	public boolean dropCourse(int studentId, int semesterId, String courseId) throws CourseNotInCart, CourseNotFoundException;

	/**
	 * @param studentId
	 * @param semesterId
	 * @return
	 * @throws SQLException
	 */

	public boolean finishRegistration(int studentId, int semesterId) throws InvalidSemesterRegistration,PaymentDoneException;
	
	/**
	 * Method to view all courses available
	 * @return list of all courses with available seats
	 */
	public ArrayList<Course> viewAvailableCourses() throws Exception;
}
