/**
 * 
 */
package com.flipkart.business;

import com.flipkart.bean.ReportCard;

/**
 * @author Aeron
 *
 */
public interface ReportCardInterface {
	
	/**
	 * Method to get student's SPI
	 * @param RC
	 * @return spi for that semester and student
	 */
	public Float getSPI(ReportCard RC) ;

	/*
	 * Method to get student's grades
	 * @param studentId
	 * @param semesterId
	 * @return student's grades for that semester
	public HashMap<String, Integer> viewGrades(int studentId, int semesterId) throws StudentNotRegisteredException, ReportCardNotFoundException;


	 * Method to get student's grades for a course
	 * @param studentId
	 * @param semesterId
	 * @param courseId
	 * @return student's grades for that course
	public HashMap<String, Integer> viewCourseGrade(int studentId, int semesterId, int courseId) throws StudentNotRegisteredException, ReportCardNotFoundException, CourseNotFoundException, CourseNotAssignedException;


	 * Method to make report card visible to the student
	 * @param studentId
	 * @param semesterId
	 * @return Boolean to indicate if operation is successful
	 * (e.g. check if all grades marked)

	public Boolean makeVisible(int studentId, int semesterId) throws GradeNotAddedException, FeesPendingException;
	*/
	
}
