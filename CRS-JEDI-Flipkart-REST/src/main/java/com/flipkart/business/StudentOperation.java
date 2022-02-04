package com.flipkart.business;

import com.flipkart.bean.Course;
import com.flipkart.bean.ReportCard;
import com.flipkart.bean.Student;
import com.flipkart.dao.StudentDaoInterface;
import com.flipkart.dao.StudentDaoOperation;
import com.flipkart.exception.*;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class StudentOperation implements StudentInterface {

	private static final Logger logger = Logger.getLogger(StudentOperation.class);
	private static volatile StudentOperation instance=null;
	StudentDaoInterface SDO =StudentDaoOperation.getInstance();

	public StudentOperation()
	{
		
	}
	/**
	 * Method to make StudentOperation Singleton
	 * @return
	 */
	public static StudentOperation getInstance()
	{
		if(instance==null)
		{
			// This is a synchronized block, when multiple threads will access this instance
			synchronized(StudentOperation.class){
				instance=new StudentOperation();
			}
		}
		return instance;
	}

	@Override
	public ReportCard viewReportCard(int StudentID, int semesterId) throws Exception {

		ReportCard R = new ReportCard();

		try {
			R = SDO.viewReportCard(StudentID,semesterId);
			

		} catch (Exception e) {
			throw e;
		}

		ReportCardOperation report = new ReportCardOperation();
		R.setSpi(report.getSPI(R));
		R.setSemesterID(semesterId);
		R.setStudentID(StudentID);
		return R;
	}

	@Override
	public List<Course> viewRegisteredCourses(int studentID, int semesterId) throws StudentNotRegisteredException, SQLException {

		try {
			List<Course> courses = SDO.viewRegisteredCourses(studentID,semesterId);

			return courses;

		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Student addStudent(String userName, String name, String password,String department ,String contactNumber, Integer joiningYear)throws UsernameTakenException {

		Student newStudent = new Student();

		try {
			newStudent.setUserID(userName);
			newStudent.setName(name);
			newStudent.setPassword(password);
			newStudent.setDepartment(department);
			newStudent.setContactNumber(contactNumber);
			newStudent.setJoiningYear(joiningYear);
			SDO.addStudent(newStudent);

			return newStudent;

		} catch (UsernameTakenException e) {
			throw e;
		}
	}

	public int getStudentIDFromUserName(String username)throws Exception {

		try {
			return SDO.getStudentIDFromUserName(username);
		} catch (StudentNotRegisteredException e) {
			throw e;
		}

		
	}

	public Boolean checkPaymentWindow(int StudentID)  {

		try {
			return SDO.checkPaymentWindow(StudentID);
		} catch (PaymentWindowException | StudentNotRegisteredException e ) {
			logger.error(e.getMessage());
		}

		return false;
	}
	
}
