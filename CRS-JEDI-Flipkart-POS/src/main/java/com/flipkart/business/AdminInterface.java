package com.flipkart.business;

import com.flipkart.bean.Professor;
import com.flipkart.bean.ReportCard;
import com.flipkart.bean.Student;
import com.flipkart.exception.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Dell
 *
 */
public interface AdminInterface {

	/**
	 * Enable fee payment for a semester.
	 * @param semesterId
	 */
	void enableFeePayment(int semesterId);

	/**
	 * Approve student semester registration.
	 * @param studentId
	 * @throws StudentNotApprovedException 
	 * @throws FeesPendingException 
	 */
	void approveStudentRegistration(int studentId,int semesterId) throws StudentNotRegisteredException, FeesPendingException, StudentNotApprovedException;
	
	/**
	 * Add a new professor in the system.
	 * @param professor
	 */
	void addProfessor(Professor professor) throws ProfessorNotAddedException;
	
	/**
	 * Remove a professor from the system.
	 * @param professorID
	 */
	void removeProfessor(int professorID);
	
	/**
	 * Generate report card and SPI for students.
	 * @param studentID
	 * @return 
	 * @throws StudentNotApprovedException 
	 * @throws FeesPendingException 
	 */
	ReportCard generateReportCard(int studentID) throws GradeNotAddedException, StudentNotApprovedException, FeesPendingException;
	
	/**
	 * Remove an existing course from the catalog.
	 * @param courseID
	 */
	void removeCourse(String courseID) throws CourseNotFoundException, CourseNotDeletedException;

	/**
	 * Add a new course in the catalog.
	 * @param course_name
	 * @param courseID
	 * @param semester
	 * @throws CourseAlreadyPresentException
	 */
	void addCourse(String course_name, String courseID, int semester) throws CourseAlreadyPresentException;

	/**
	 * View list of students enrolled in all courses.
	 * @param courseID
	 * @param semester
	 * @param viewAll
	 * @return
	 */
	HashMap<String, ArrayList<Integer>> viewCourseStudentList(String courseID, int semester, Boolean viewAll);

	/**
	 * Get list of students' login accounts which are pending to be approved.
	 * @return
	 */
	List<Student> getPendingStudentAccountsList();

	/**
	 * Approve a student's pending account.
	 * @param studentID
	 */
	void approveStudentAccount(Integer studentID);
}