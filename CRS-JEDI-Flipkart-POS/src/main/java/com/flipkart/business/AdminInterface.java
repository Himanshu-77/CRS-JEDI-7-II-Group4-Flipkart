package com.flipkart.business;

import com.flipkart.bean.Professor;
import com.flipkart.bean.ReportCard;
import com.flipkart.bean.Student;
import com.flipkart.exception.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author rutwi
 *
 */
public interface AdminInterface {

	/**
	 * @param semesterId
	 */

	public void enableFeePayment(int semesterId);

	/**
	 * @param students
	 * @throws StudentNotApprovedException 
	 * @throws FeesPendingException 
	 */
	public void approveStudentRegistration(int studentId,int semesterId) throws StudentNotRegisteredException, StudentNotRegisteredException, FeesPendingException, StudentNotApprovedException;
	
	/**
	 * @param professor
	 */
	public void addProfessor(Professor professor) throws ProfessorNotAddedException;
	
	/**
	 * @param professor
	 */
	public void removeProfessor(int professorID);
	
	/**
	 * @param studentID
	 * @return 
	 * @throws StudentNotApprovedException 
	 * @throws FeesPendingException 
	 */
	public ReportCard generateReportCard(int studentID) throws GradeNotAddedException, StudentNotApprovedException, FeesPendingException;
	
	/**
	 * @param courseID
	 * @param courseCatalog
	 */
	public void removeCourse(String courseID) throws CourseNotFoundException, CourseNotDeletedException;
	
	/**
	 * @param courseID
	 * @param courseCatalog
	 */
	public void addCourse(String course_name, String courseID, int semester) throws CourseAlreadyPresentException;

	public HashMap<String, ArrayList<Integer>> viewCourseStudentList(String courseID, int semester, Boolean viewAll);

	public List<Student> getPendingStudentAccountsList();

	public void approveStudentAccount(Integer studentID);
}