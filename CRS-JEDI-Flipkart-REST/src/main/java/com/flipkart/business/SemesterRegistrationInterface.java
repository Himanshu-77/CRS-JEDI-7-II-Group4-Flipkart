/**
 * 
 */
package com.flipkart.business;

import com.flipkart.bean.Course;

import java.util.ArrayList;

/**
 * @author Asus
 *
 */
public interface SemesterRegistrationInterface {
	
	/**
	 * Method to add Course selected by student 
	 * @param studentId
	 * @param semesterId
	 * @param courseId 
	 * @return the course if it is added successfully, else null
	 */
	public boolean addCourse(int studentId, int semesterId, String courseId, boolean isPrimary);
	
	/**
	 * Method to drop Course selected by student 
	 * @param studentId
	 * @param semesterId
	 * @param courseId 
	 * @return Boolean value indicating if it is was dropped successfully
	 */

	public boolean dropCourse(int studentId, int semesterId, String courseId);
	
	/**
	 * Method to view all courses available
	 * @return list of all courses with availbale seats
	 */

	public ArrayList<Course> viewAvailableCourses() throws Exception;

	/**
	 * @param studentId
	 * @param semesterId
	 * @return
	 */
	public boolean finishRegistration(int studentId, int semesterId);
}
