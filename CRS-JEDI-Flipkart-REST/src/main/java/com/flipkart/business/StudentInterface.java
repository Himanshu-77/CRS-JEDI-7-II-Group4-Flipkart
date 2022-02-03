/**
 * 
 */
package com.flipkart.business;

import com.flipkart.bean.ReportCard;
import com.flipkart.bean.Student;
import com.flipkart.exception.*;

import java.sql.SQLException;

/**
 * @author rutwi
 *
 */
public interface StudentInterface {

	/**
	 * @param StudentID
	 * @return payment window status for semester in which student has registered
	 */
	public Boolean checkPaymentWindow(int StudentID);

	/**
	 * @param userName
	 * @param name
	 * @param password
	 * @param department
	 * @param contactNumber
	 * @param joiningYear
	 * @return
	 */
	public Student addStudent (String userName, String name, String password,String department, String contactNumber, Integer joiningYear) throws UsernameTakenException;
	
	
	/**
	 * @param StudentID
	 * @param semesterId
	 * @return reportCard
	 * @throws StudentNotApprovedException 
	 * @throws SQLException 
	 */
	public ReportCard viewReportCard(int StudentID, int semesterId) throws Exception;
	
	/**
	 * @param studentID
	 * @param semesterId
	 * @return course list
	 * @throws SQLException 
	 */
	public void viewRegisteredCourses(int studentID, int semesterId) throws StudentNotRegisteredException, SQLException;

	/**
	 * @param username
	 * @return
	 */
	public int getStudentIDFromUserName(String username);
}