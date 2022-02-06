/**
 * 
 */
package com.flipkart.business;

import com.flipkart.bean.ReportCard;
import com.flipkart.bean.Student;
import com.flipkart.exception.*;

import java.sql.SQLException;

/**
 * @author Aeron
 *
 */
public interface StudentInterface {

	/**
	 * @param StudentID
	 * @return payment window status for semester in which student has registered
	 */
	Boolean checkPaymentWindow(int StudentID);

	/**
	 * Add student details when he registers for a new account.
	 * @param userName
	 * @param name
	 * @param password
	 * @param department
	 * @param contactNumber
	 * @param joiningYear
	 * @return
	 */
	Student addStudent(String userName, String name, String password,String department, String contactNumber, Integer joiningYear);
	
	
	/**
	 * View report card for logged-in student.
	 * @param StudentID
	 * @param semesterId
	 * @return reportCard
	 * @throws StudentNotApprovedException 
	 * @throws SQLException 
	 */
	ReportCard viewReportCard(int StudentID, int semesterId) throws GradeNotAddedException,FeesPendingException, SQLException, StudentNotApprovedException;
	
	/**
	 * View all the courses registered by the student.
	 * @param studentID
	 * @param semesterId
	 * @return course list
	 * @throws SQLException 
	 */
	void viewRegisteredCourses(int studentID, int semesterId) throws StudentNotRegisteredException, SQLException;

	/**
	 * Get student ID by provided username.
	 * @param username
	 * @return
	 */
	int getStudentIDFromUserName(String username);
}