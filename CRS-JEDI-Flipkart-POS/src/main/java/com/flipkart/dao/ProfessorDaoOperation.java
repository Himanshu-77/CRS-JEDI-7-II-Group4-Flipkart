/**
 * 
 */
package com.flipkart.dao;

import com.flipkart.bean.Course;
import com.flipkart.bean.RegisteredCourses;
import com.flipkart.constants.SQLQueries;
import com.flipkart.exception.*;
import com.flipkart.utils.DBUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author Dell
 *  Class to implement Professor Dao Operations
 */
public class ProfessorDaoOperation implements ProfessorDaoInterface {

	private static Logger logger = LogManager.getLogger(ProfessorDaoOperation.class);
	
	private volatile static ProfessorDaoOperation instance=null;

	private ProfessorDaoOperation(){

	}

//	Method to make ProfessorDaoOperation Singleton
	public static ProfessorDaoOperation getInstance(){
		if(instance==null)
		{
			synchronized (ProfessorDaoOperation.class){
				instance=new ProfessorDaoOperation();
			}
		}
		return instance;
	}


	/**
	 * Method to Grade a Student using SQL commands
	 * @param studentID
	 * @param courseID
	 * @param grade
	 * @throws GradeNotAddedException,StudentNotRegisteredException
	 */

	@Override
	public void addGrade(Integer studentID, Integer semesterID, String courseID, Integer grade) throws GradeNotAddedException,StudentNotRegisteredException {
		
		Connection connection=DBUtil.getConnection();
		try 
		{
			PreparedStatement stmt;

			PreparedStatement checkStmt = connection.prepareStatement(SQLQueries.CHECK_COURSE_VALIDITY(studentID, semesterID, courseID));
			checkStmt.setInt(1, studentID);
			checkStmt.setString(2, courseID);
			checkStmt.setInt(3, semesterID);
			ResultSet rs = checkStmt.executeQuery();
			
			if(!rs.next()) {
				throw new StudentNotRegisteredException();
			}
			
			if(!rs.getBoolean("is_approved")) {
				throw new StudentNotRegisteredException();
				
			}
			else {
				stmt = connection.prepareStatement(SQLQueries.ADD_GRADE(studentID, semesterID, courseID, grade));
		    	stmt.setInt(1, grade);
				stmt.setInt(2, studentID);
				stmt.setString(3, courseID);
				stmt.setInt(4, semesterID);

				int res = stmt.executeUpdate();
				
	            if (res > 0)     
	            	
	                logger.info("Successfully Inserted");            
	            else 
	            {
	         
	            	throw new GradeNotAddedException(studentID);
	            }
			}
	                
		}	
			catch(SQLException e) {
			}
	}
			
	/**
	 * Method to View student details for students who are registered in a particular course
	 * @param professorID
	 * @return the enrolled students for the corresponding professor and course code.
	 * @throws NoStudentInCourseException
	 */

	@Override
	public ArrayList<RegisteredCourses> viewCourseStudents(String courseID, Integer semesterID) throws NoStudentInCourseException{
		Connection connection=DBUtil.getConnection();
		try {
			PreparedStatement stmt = connection.prepareStatement(SQLQueries.VIEW_REGISTERED_STUDENTS(courseID, semesterID));
			stmt.setString(1, courseID);
			stmt.setInt(2, semesterID);
			ResultSet rs = stmt.executeQuery();
			
			ArrayList<RegisteredCourses> ans = new ArrayList<RegisteredCourses>();
			ArrayList<String> temp = new ArrayList<String>();
			if(!rs.next())
			{

				throw new NoStudentInCourseException(courseID);
			}
			else {
				do  {
					temp.add(rs.getString("course_id"));
					RegisteredCourses tempObject = new RegisteredCourses(rs.getInt("student_id"), rs.getInt("semester_id"), temp);
					ans.add(tempObject);
					temp.clear();
				}while(rs.next());
			}
			

			return ans;
		}
		catch(SQLException e) {
		}
		
		return null;
	}

	/**
	 * Method to view courses which the professor is associated with
	 * @param instructorID
	 * @return the enrolled students for the corresponding professor and course code.
	 * @throws ProfessorNotAssignedException
	 */
	@Override
	public ArrayList<Course> viewCourseProf(Integer instructorID) throws ProfessorNotAssignedException {

		ArrayList<Course>ans = new ArrayList<Course>();
		Connection connection=DBUtil.getConnection();
		try {
			

			PreparedStatement stmt = connection.prepareStatement(SQLQueries.VIEW_ASSOCIATED_PROFESSOR(instructorID));

			stmt.setInt(1, instructorID);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Course c = new Course(rs.getString("courseID"), rs.getString("course_name"), rs.getString("instructor"), 10, rs.getInt("available_seats"), 0);
				ans.add(c);
			}

			if(!ans.isEmpty()) {
				return ans;
			}
			else {
				throw new ProfessorNotAssignedException(instructorID);
			}
		} catch(SQLException e) {

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return ans;
	}

	/**
	 * Method for Professor to register for a course if no one is allocated to it
	 * @param instructorID
	 * @param semesterID
	 * @param courseID
	 * @return true if Successfully registered else false
	 * @throws ProfessorCourseRegistrationException
	 */
	@Override
	public Boolean registerCourse(Integer instructorID, Integer semesterID, String courseID) throws ProfessorCourseRegistrationException{

		
		Connection connection=DBUtil.getConnection();
		try {
			
			String sql = "SELECT * FROM course_catalog WHERE courseID = '"+courseID+"' AND offered_semester = "+semesterID + " AND instructor is NULL";
			String sql1 = "UPDATE course_catalog set instructor = + '"+instructorID+"' WHERE courseID = '"+courseID+"' AND offered_semester = "+semesterID;
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);
			
			if(!rs.next())
			{

				logger.error("Course already registered / Course doesn't exist!!");
				return false;
			}
			else {
			
				PreparedStatement stmt1 = connection.prepareStatement(sql1);
				int res = stmt1.executeUpdate();
				if (res > 0)            

					logger.info("Successfully Registered");            
	            
				else{
	            	throw new ProfessorCourseRegistrationException(instructorID, semesterID, courseID);
	            }
			}
				
			
			return true;
			
		}
		
		catch(SQLException e)
		{
			return false;
			
		}
	}

	/**
	 * Method to find professor ID via his username
	 * @param username
	 * @return instructor id
	 * @throws ProfessorNotRegisteredException
	 */
	public int getProfessorIDFromUserName(String username) throws ProfessorNotRegisteredException  {

		int professorID = -1;

		Connection connection=DBUtil.getConnection();

		try
		{			
			PreparedStatement preparedStatement = connection.prepareStatement(SQLQueries.VIEW_PROFESSOR_ID(username));
			preparedStatement.setString(1, username);
			ResultSet results=preparedStatement.executeQuery();

			if(results.next()) {
				professorID = results.getInt("instructor_ID");

				return professorID;
			}
			else {

				throw new ProfessorNotRegisteredException();
			}
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}

		return professorID;
	}

}
