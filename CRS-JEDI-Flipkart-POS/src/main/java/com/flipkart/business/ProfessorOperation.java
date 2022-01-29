/**
 * 
 */
package com.flipkart.business;

import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.flipkart.bean.Course;
//import com.flipkart.bean.Grade;
import com.flipkart.bean.RegisteredCourses;
import com.flipkart.exception.GradeNotAddedException;
import com.flipkart.exception.NoStudentInCourseException;
import com.flipkart.exception.ProfessorNotAssignedException;
import com.flipkart.exception.StudentNotRegisteredException;

/**
 * @author Dell
 *
 */

public class ProfessorOperation implements ProfessorInterface {

	private static Logger logger = LogManager.getLogger(ProfessorOperation.class);
	
	private static volatile ProfessorOperation instance=null;
	private ProfessorOperation()
	{

	}
	/**
	 * Method to make ProfessorOperation Singleton
	 * @return
	 */
	public static ProfessorOperation getInstance()
	{
		if(instance==null)
		{
			// This is a synchronized block, when multiple threads will access this instance
			synchronized(ProfessorOperation.class){
				instance=new ProfessorOperation();
			}
		}
		return instance;
	}


	//Add grade
	@Override
	public void addGrade(Integer studentID, Integer semesterID, String courseID, Integer grade)  
	{
		

	}

	//view student details who have registered for a particular course
	@Override

	public void viewCourseStudents(String courseID, Integer semesterID) {
		

	}

	//view course details which the professor is associated with
	@Override
	public void viewCourseProf(int instructorID) {
	

		
	}

	@Override

	public void registerCourse(int instructorID, Integer semesterID, String courseID) {

	}

}
