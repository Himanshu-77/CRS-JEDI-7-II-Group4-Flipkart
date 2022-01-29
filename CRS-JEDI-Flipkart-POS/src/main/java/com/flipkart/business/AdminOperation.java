package com.flipkart.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.flipkart.bean.*;
import com.flipkart.exception.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Dell
 *
 */

public class AdminOperation implements AdminInterface {

	private static volatile AdminOperation instance = null;
	private static final Logger logger = LogManager.getLogger(AdminOperation.class);

	private AdminOperation()
	{

	}

	/**
	 * Method to make AdminOperation Singleton
	 */
	public static AdminOperation getInstance()
	{
		if(instance == null)
		{
			synchronized(AdminOperation.class){
				instance = new AdminOperation();
			}
		}
		return instance;
	}

//	AdminDaoInterface ado  = AdminDaoOperation.getInstance();

	@Override
	public void approveStudentRegistration(int studentId,int semesterId) {


	}

	@Override
	public void addProfessor(Professor professor) {


	}

	@Override
	public void removeProfessor(int professorID) {

	}

	@Override
	public void removeCourse(String courseID) {


	}
	

	@Override
	public void addCourse(String course_name, String courseID, int semester) {
		Course newCourse = new Course();
		newCourse.setCoursename(course_name);
		newCourse.setCourseID(courseID);
		newCourse.setOfferedSemester(semester);
		newCourse.setAvailableSeats(10);

//		ado.addCourse(newCourse);
	}

	
	@Override
	public HashMap<String,ArrayList<Integer> > viewCourseStudentList(String courseID, int semester, Boolean viewAll) {
		HashMap<String,ArrayList<Integer> > x = new HashMap<String,ArrayList<Integer> >();
		return x ;
	}

	@Override
	public ReportCard generateReportCard(int studentID) {

		ReportCard R = new ReportCard();

		return R;
	}

	
	@Override
	public List<Student> getPendingStudentAccountsList() {
		List<Student> x = new ArrayList<Student>();
		return x;

	}

	@Override
	public void approveStudentAccount(Integer studentID) {

	}
}