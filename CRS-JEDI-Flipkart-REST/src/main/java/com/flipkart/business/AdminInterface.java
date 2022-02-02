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
	 * @param semesterId
	 */
	public void enableFeePayment(int semesterId);

	/**
	 * @param studentId
	 * @throws StudentNotApprovedException 
	 * @throws FeesPendingException 
	 */
	public void approveStudentRegistration(int studentId,int semesterId) throws StudentNotRegisteredException, FeesPendingException, StudentNotApprovedException;
	
	/**
	 * @param professor
	 */
	public void addProfessor(Professor professor) throws ProfessorNotAddedException;
	
	/**
	 * @param professorID
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
	 */
	public void removeCourse(String courseID) throws CourseNotFoundException, CourseNotDeletedException;

	public void addCourse(String course_name, String courseID, int semester) throws CourseAlreadyPresentException;

	/**
	 * @param courseID
	 * @param semester
	 * @param viewAll
	 * @return
	 */
	public HashMap<String, ArrayList<Integer>> viewCourseStudentList(String courseID, int semester, Boolean viewAll);

	public List<Student> getPendingStudentAccountsList();

	/**
	 * @param studentID
	 */
	public void approveStudentAccount(Integer studentID);
}