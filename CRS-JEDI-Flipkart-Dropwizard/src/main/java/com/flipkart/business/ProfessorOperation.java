/**
 * 
 */
package com.flipkart.business;

import com.flipkart.bean.Course;
import com.flipkart.bean.RegisteredCourses;
import com.flipkart.dao.ProfessorDaoInterface;
import com.flipkart.dao.ProfessorDaoOperation;
import com.flipkart.exception.*;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author Aeron
 *
 */

public class ProfessorOperation implements ProfessorInterface {

	private static Logger logger = Logger.getLogger(ProfessorOperation.class);
	
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
	public void addGrade(Integer studentID, Integer semesterID, String courseID, Integer grade) throws  Exception
	{
		ProfessorDaoInterface profObj= ProfessorDaoOperation.getInstance();
			try {
				profObj.addGrade(studentID, semesterID,courseID, grade);
				System.out.println("Grade added successfully");
			} 
			catch (Exception e) {
				throw e;
			}
	}

	// To view student details who have registered for a particular course
	@Override
	public ArrayList<RegisteredCourses> viewCourseStudents(String courseID, Integer semesterID) throws Exception {
		
		ArrayList<RegisteredCourses>ans = new ArrayList<RegisteredCourses>();
		
		
			ProfessorDaoInterface profObj= ProfessorDaoOperation.getInstance();
			try
			{
				ans = profObj.viewCourseStudents(courseID, semesterID);
				return ans;
			}
			
			 
		catch(Exception e) {
			throw e;
		}
		
			
	}

	// View course details which the professor is associated with
	@Override
	public ArrayList<Course> viewCourseProf(int instructorID) throws Exception{
	
		ArrayList<Course>ans = new ArrayList<Course>();
		

			try {
				
				ProfessorDaoInterface profObj= ProfessorDaoOperation.getInstance();
				ans = profObj.viewCourseProf(instructorID);
			return ans;
			}
			
		catch(Exception e) {
			throw e;
		}
	}
	

	@Override
	public void registerCourse(int instructorID, Integer semesterID, String courseID) throws Exception {
		ProfessorDaoInterface profObj= ProfessorDaoOperation.getInstance();
		try {
			Boolean ans = profObj.registerCourse(instructorID, semesterID, courseID);
		}
		catch(Exception e) {
			throw e;
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
