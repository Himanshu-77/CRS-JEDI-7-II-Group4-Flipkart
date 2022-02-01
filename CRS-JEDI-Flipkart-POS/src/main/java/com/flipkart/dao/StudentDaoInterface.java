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
	public Boolean checkPaymentWindow(int StudentID) throws PaymentWindowException,StudentNotRegisteredException;

	/**
	 * @param StudentID

	 * @param semesterId
	 * @return reportCard
	 * @throws FeesPendingException 
	 * @throws StudentNotApprovedException 
	 */

	public ReportCard viewReportCard(int StudentID, int semesterId) throws GradeNotAddedException, StudentNotApprovedException, FeesPendingException, ReportCardNotGeneratedException;


	/**
	 * @param studentID
	 * @param semesterId
	 */

	public List<Course> viewRegisteredCourses(int studentID, int semesterId) throws StudentNotRegisteredException;
	public Student addStudent(Student student) throws SQLException;
	
	public int getStudentIDFromUserName(String username) throws StudentNotRegisteredException;
	
}
