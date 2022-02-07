/**
 * 
 */
package com.flipkart.business;

import com.flipkart.bean.Course;
import com.flipkart.bean.RegisteredCourses;
import com.flipkart.dao.ProfessorDaoInterface;
import com.flipkart.dao.ProfessorDaoOperation;
import com.flipkart.exception.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author Aeron
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

	@Override
	public void addGrade(Integer studentID, Integer semesterID, String courseID, Integer grade)  
	{
		ProfessorDaoInterface profObj= ProfessorDaoOperation.getInstance();
			try {
				profObj.addGrade(studentID, semesterID,courseID, grade);
				System.out.println("Grade added successfully");
			} 
			catch (GradeNotAddedException  | StudentNotRegisteredException | SQLException e) {
				System.out.println(e.getMessage());
			}
	}

	// To view student details who have registered for a particular course
	@Override
	public void viewCourseStudents(String courseID, Integer semesterID) {
		
		ArrayList<RegisteredCourses>ans = new ArrayList<RegisteredCourses>();
		
		try {
			ProfessorDaoInterface profObj= ProfessorDaoOperation.getInstance();
			try
			{
				ans = profObj.viewCourseStudents(courseID, semesterID);
				for (RegisteredCourses r:ans) {
					System.out.println("studentID = " + r.getStudentID()+ " Semester ID = "+r.getSemesterID());
				}
			}
			catch(NoStudentInCourseException e) {
				logger.error(e.getMessage());
			}
			 
		}
		catch(Exception e) {
			logger.error(e.getMessage());
		}
		
			
	}

	// View course details which the professor is associated with
	@Override
	public void viewCourseProf(int instructorID) {
	
		ArrayList<Course>ans = new ArrayList<Course>();
		try {

			try {
				ProfessorDaoInterface profObj= ProfessorDaoOperation.getInstance();
			ans = profObj.viewCourseProf(instructorID);
			for (Course c: ans) {
				System.out.println("CourseID = " + c.getCourseID()+ " Course Name = " + c.getCoursename());
				}
			}
			catch(ProfessorNotAssignedException e) {
				logger.error(e.getMessage());
			}
		}
		catch(Exception e) {
			logger.error(e.getMessage());
		}
		
	}

	@Override
	public void registerCourse(int instructorID, Integer semesterID, String courseID) {
		ProfessorDaoInterface profObj= ProfessorDaoOperation.getInstance();
		try {
			Boolean ans = profObj.registerCourse(instructorID, semesterID, courseID);
			if(ans){
				System.out.println("Course has been registered");
			}
		}
		catch(Exception e) {
			logger.error(e.getMessage());
		}
	}

	@Override
	public Integer getProfessorID(String username) throws SQLException, ProfessorNotRegisteredException{
		ProfessorDaoOperation pdo = ProfessorDaoOperation.getInstance();
		try {
			return pdo.getProfessorIDFromUserName(username);
		} catch (Exception e) {

			throw e;
		}
	}


}
