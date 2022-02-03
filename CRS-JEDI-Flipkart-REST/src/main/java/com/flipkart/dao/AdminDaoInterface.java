package com.flipkart.dao;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.ReportCard;
import com.flipkart.bean.Student;
import com.flipkart.exception.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Aeron
 *
 */
public interface AdminDaoInterface {

	/**
	 * @param studentId
	 * @param semesterId
	 * @throws FeesPendingException
	 * @throws StudentNotApprovedException
	 */
	public void approveStudentRegistration(int studentId,int semesterId) throws FeesPendingException, StudentNotApprovedException;


	/**
	 * @param semesterId
	 */
	public void enableFeePaymentWindow(int semesterId) throws SQLException;

	/**
	 * @param professor
	 */
	public void addProfessor(Professor professor) throws Exception;

	
	/**
	 * @param professorID
	 */
	public void removeProfessor(int professorID) throws Exception;

	
	/**
	 * @param studentID
	 * @return 
	 * @throws StudentNotApprovedException 
	 * @throws FeesPendingException 
	 * @throws GradeNotAddedException 
	 */

	public ReportCard generateReportCard(int studentID) throws Exception;


	/**
	 * @param courseID
	 * @throws CourseNotFoundException
	 */
	public void removeCourse(String courseID) throws Exception;


	/**
	 * @param course
	 */
	public void addCourse(Course course) throws Exception;

	/**
	 * @param courseID
	 * @param semesterId
	 * @param viewAll
	 * @return
	 */
	public HashMap<String, ArrayList<Integer>> viewCourseStudentList(String courseID, int semesterId, Boolean viewAll) throws Exception;

	/**
	 * @return
	 */
	public List<Student> getPendingStudentAccountsList() throws Exception;

	/**
	 * @param studentId
	 */
	public void approveStudentAccount(int studentId) throws Exception;

}