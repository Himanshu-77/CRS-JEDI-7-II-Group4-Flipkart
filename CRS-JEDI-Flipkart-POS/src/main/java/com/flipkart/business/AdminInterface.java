package com.flipkart.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.flipkart.bean.Professor;
import com.flipkart.bean.ReportCard;
import com.flipkart.bean.Student;
import com.flipkart.exception.CourseAlreadyPresentException;
import com.flipkart.exception.CourseNotDeletedException;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.FeesPendingException;
import com.flipkart.exception.GradeNotAddedException;
import com.flipkart.exception.ProfessorNotAddedException;
import com.flipkart.exception.StudentNotApprovedException;
import com.flipkart.exception.StudentNotRegisteredException;

/**
 * @author rutwi
 *
 */
public interface AdminInterface {
	
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