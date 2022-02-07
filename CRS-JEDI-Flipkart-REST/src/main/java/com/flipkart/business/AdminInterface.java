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
	public void enableFeePayment(int semesterId) throws Exception ;

	/**
	 * @param studentId
	 * @throws StudentNotApprovedException 
	 * @throws FeesPendingException 
	 */
	public void approveStudentRegistration(int studentId,int semesterId) throws Exception;
	
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
	 */
	public ReportCard generateReportCard(int studentID) throws Exception;
	
	/**
	 * @param courseID
	 */
	public void removeCourse(String courseID) throws Exception;

	/**
	 * 
	 * @param course_name
	 * @param courseID
	 * @param semester
	 * @throws Exception
	 */
	
	public void addCourse(String course_name, String courseID, int semester) throws Exception;

	/**
	 * @param courseID
	 * @param semester
	 * @param viewAll
	 * @return
	 */
	public HashMap<String, ArrayList<Integer>> viewCourseStudentList(String courseID, int semester, Boolean viewAll)  throws Exception;

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	
	public List<Student> getPendingStudentAccountsList() throws Exception;

	/**
	 * @param studentID
	 */
	public void approveStudentAccount(Integer studentID) throws Exception;
}