package com.flipkart.business;

import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.ReportCard;
import com.flipkart.bean.Student;
import com.flipkart.exception.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StudentOperation implements StudentInterface {

	private static final Logger logger = LogManager.getLogger(StudentOperation.class);
	private static volatile StudentOperation instance=null;

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
	public ReportCard viewReportCard(int StudentID, int semesterId)  {

		ReportCard R = new ReportCard();
		return R;
	}

	@Override
	public void viewRegisteredCourses(int studentID, int semesterId) {


	}

	@Override
	public Student addStudent(String userName, String name, String password,String department ,String contactNumber, Integer joiningYear) {

		Student newStudent = new Student();
		return newStudent;
	}

	public int getStudentIDFromUserName(String username) {

		return -1;
	}

}
