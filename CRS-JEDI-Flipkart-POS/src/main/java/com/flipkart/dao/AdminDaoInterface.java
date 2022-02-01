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
 * @author rutwi
 *
 */
public interface AdminDaoInterface {
	
	/**
	 * @param students
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
	public void addProfessor(Professor professor);

	
	/**
	 * @param professor
	 */

	public void removeProfessor(int professorID) throws ProfessorNotRegisteredException;

	
	/**
	 * @param studentID
	 * @return 
	 * @throws StudentNotApprovedException 
	 * @throws FeesPendingException 
	 * @throws GradeNotAddedException 
	 */

	public ReportCard generateReportCard(int studentID) throws StudentNotApprovedException;

	
	/**
	 * @param courseID
	 * @param courseCatalog
	 */

	public void removeCourse(String courseID) throws CourseNotFoundException;

	
	/**
	 * @param courseID
	 * @param courseCatalog
	 */

	public void addCourse(Course course);

	
	public HashMap<String, ArrayList<Integer>> viewCourseStudentList(String courseID, int semesterId, Boolean viewAll);
	
	public List<Student> getPendingStudentAccountsList();
	
	public void approveStudentAccount(int studentId);

}