/**
 * 
 */
package com.flipkart.dao;

import com.flipkart.bean.Course;
import com.flipkart.bean.ReportCard;
import com.flipkart.bean.Student;
import com.flipkart.exception.*;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Dell
 *
 */
public interface StudentDaoInterface {

	/**
	 * @param StudentID
	 * @return payment window status
	 * @throws SQLException
	 * @throws PaymentWindowException

	 */
	Boolean checkPaymentWindow(int StudentID) throws PaymentWindowException,StudentNotRegisteredException;

	/**
	 * @param StudentID

	 * @param semesterId
	 * @return reportCard
	 * @throws FeesPendingException 
	 * @throws StudentNotApprovedException 
	 */
	ReportCard viewReportCard(int StudentID, int semesterId) throws GradeNotAddedException, StudentNotApprovedException, FeesPendingException, ReportCardNotGeneratedException;


	/**
	 * @param studentID
	 * @param semesterId
	 */
	List<Course> viewRegisteredCourses(int studentID, int semesterId) throws StudentNotRegisteredException;

	/**
	 * @param student
	 * @return
	 * @throws SQLException
	 */
	Student addStudent(Student student) throws UsernameTakenException;

	/**
	 * @param username
	 * @return
	 * @throws StudentNotRegisteredException
	 */
	int getStudentIDFromUserName(String username) throws StudentNotRegisteredException;
	
}
