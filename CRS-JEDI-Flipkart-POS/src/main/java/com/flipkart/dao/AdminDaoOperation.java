
package com.flipkart.dao;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.ReportCard;
import com.flipkart.bean.Student;
import com.flipkart.business.StudentOperation;
import com.flipkart.constants.SQLQueries;
import com.flipkart.constants.constants;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.FeesPendingException;
import com.flipkart.exception.ProfessorNotRegisteredException;
import com.flipkart.exception.StudentNotApprovedException;
import com.flipkart.utils.DBUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * @author rutwi
 *
 */
public class AdminDaoOperation implements AdminDaoInterface {
	
	private PreparedStatement statement = null;

	private static volatile AdminDaoOperation instance = null;
	private static final Logger logger = LogManager.getLogger(AdminDaoOperation.class);


	
	/**
	 * Default Constructor
	 */
	private AdminDaoOperation(){}
	
	/**
	 * Method to make AdminDaoOperation Singleton
	 * @return
	 */
	public static AdminDaoOperation getInstance()
	{
		if(instance == null)
		{
			synchronized(AdminDaoOperation.class){
				instance = new AdminDaoOperation();
			}
		}
		return instance;
	}	

	@Override
	public void approveStudentRegistration(int studentId,int semesterId) throws FeesPendingException, StudentNotApprovedException {
		
		Connection connection = DBUtil.getConnection();
		
		
		try {
			statement = connection.prepareStatement(SQLQueries.GET_STUDENT_BY_ID(studentId, semesterId));
//			statement.setInt(1, studentId);
//			statement.setInt(2, semesterId);
			ResultSet rs = statement.executeQuery();
			if(!rs.next()) {
				throw new StudentNotApprovedException(studentId);
			}
			else {
			
			Boolean primary4 = true;
			Boolean fees = true;
			List<String> primary_course_ids = new ArrayList<String>();
			List<String> alternate_course_ids = new ArrayList<String>();
			do {
				if(!rs.getBoolean(7))fees=false; //fees not paid
				if(rs.getString(2)!=null) {
					if(rs.getBoolean(5)) //is primary 
						primary_course_ids.add(rs.getString(2));
					else 
						alternate_course_ids.add(rs.getString(2));
				}
			}while(rs.next());
			
			if(!fees) {
				throw new FeesPendingException(studentId);
			}
			
			if( primary_course_ids.size()  + alternate_course_ids.size() < 4) {
				throw new StudentNotApprovedException(studentId);
			}
			
			PreparedStatement update_statement = connection.prepareStatement(SQLQueries.APPROVE_STUDENT(studentId, semesterId));

			update_statement.executeUpdate();
			logger.info("Approved");
		}	
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}
			
}

	@Override
	public void addProfessor(Professor professor){
		// TODO Auto-generated method stub

		String sql = SQLQueries.ADMIN_ADD_PROFESSOR;

		Connection connection = DBUtil.getConnection();
		
		try {
			
			PreparedStatement preparedStatement0=connection.prepareStatement("SELECT MAX(instructor_ID) FROM professor");
			ResultSet results=preparedStatement0.executeQuery();
			int instructorId = 0;
			if(results.next()) {
				instructorId=results.getInt(1);
			}
			professor.setInstructorID(instructorId+1);
			
			statement = connection.prepareStatement(sql);
			statement.setString(1, professor.getUserID());
			statement.setString(2, professor.getName());
			statement.setInt(3, professor.getJoiningYear());
			statement.setString(4, professor.getContactNumber());
			statement.setString(5, professor.getPassword());
			statement.setInt(6, professor.getInstructorID());
			statement.setString(7, professor.getDesignation());
			statement.setString(8, professor.getDepartment());
			
			int row = statement.executeUpdate();
			
			System.out.println(row + " user added.");
			
		} catch (SQLException e) {

			logger.error(e.getMessage());
		}
	}

	@Override
	public void removeProfessor(int professorID) throws ProfessorNotRegisteredException{
		// TODO Auto-generated method stub

		String sql = SQLQueries.ADMIN_REMOVE_PROFESSOR;

		Connection connection = DBUtil.getConnection();
		
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, professorID);
			
			int row = statement.executeUpdate();
			if(row==0) {
				throw new ProfessorNotRegisteredException(professorID);
			}
			else {
			
				System.out.println(row + " user deleted.");
			}
			
			
		} catch (SQLException e) {

//			logger.error(e.getMessage());
		}
	}

	@Override

	public ReportCard generateReportCard(int studentID) throws StudentNotApprovedException {

		Connection connection = DBUtil.getConnection();
		ReportCard R = new ReportCard();
		
		try {
			statement = connection.prepareStatement(SQLQueries.GET_STUDENT(studentID));
						
			ResultSet rs = statement.executeQuery();
			rs.next();
			
			if(rs.getBoolean(1)) {

				StudentOperation so = new StudentOperation();
				R = so.viewReportCard(studentID, constants.SemesterID);
				
				PreparedStatement statement1 = connection.prepareStatement(SQLQueries.GENERATE_REPORT_CARD(studentID,R.getSpi()));
				statement1.executeUpdate();
			}
			
			else {
				throw new StudentNotApprovedException(studentID);
			}
			
		} catch (SQLException e) {
//			logger.error(e.getMessage());
		}
		return R;
	}

	@Override
	public void removeCourse(String courseID) throws CourseNotFoundException {

		String sql = SQLQueries.ADMIN_REMOVE_COURSE;

		Connection connection = DBUtil.getConnection();
		
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, courseID);
			
			int row = statement.executeUpdate();
			if(row == 0) {
			
				throw new CourseNotFoundException(courseID);
			}
			else {
			
				System.out.println(row + " course deleted.");
			}
			
			
		} catch (SQLException e) {
			
//			logger.error(e.getMessage());
		}
		
	}

	@Override
	public void addCourse(Course course) {
		// TODO Auto-generated method stub
		String sql = SQLQueries.ADMIN_ADD_COURSE;

		Connection connection = DBUtil.getConnection();
		
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, course.getCourseID());
			statement.setString(2, course.getCoursename());
			statement.setInt(3, course.getOfferedSemester());
			statement.setInt(4, course.getAvailableSeats());
			
			int row = statement.executeUpdate();
			
			System.out.println(row + " course added.");
			
		} catch (SQLException e) {

			logger.error(e.getMessage());

		}
		
	}

	
	@Override
	public HashMap<String,ArrayList<Integer> >  viewCourseStudentList(String courseID, int semesterId, Boolean viewAll) {
		
		Connection connection = DBUtil.getConnection();
		HashMap<String,ArrayList<Integer> > StudentList = new HashMap<String,ArrayList<Integer> >();
		 
		try {

			List<String> course_ids = new ArrayList<String>();
			
			if(viewAll) {
				statement = connection.prepareStatement(SQLQueries.GET_ALL_COURSES(semesterId));						
				ResultSet rs = statement.executeQuery();
				rs.next();
	
				do {
					course_ids.add(rs.getString(1));				
				}while(rs.next());
			}
			else {
				course_ids.add(courseID);
			}
			 
			for(String c : course_ids) {
				PreparedStatement statement2 = connection.prepareStatement(SQLQueries.GET_COURSE_STUDENTS(c,semesterId));
				ResultSet studentSet= statement2.executeQuery();
				studentSet.next();
				ArrayList<Integer> CourseStudentList = new ArrayList<Integer>();
				do {					
					CourseStudentList.add(studentSet.getInt(1));
				}while(studentSet.next());
				StudentList.put(c,CourseStudentList);
			}
			
			
			
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}
		return StudentList;
	
	}

	
	@Override
	public List<Student> getPendingStudentAccountsList() {
		
		Connection connection = DBUtil.getConnection();
		List<Student> pendingStudents = new ArrayList<Student>();
		
		try {
			statement = connection.prepareStatement(SQLQueries.GET_PENDING_STUDENT);
						
			ResultSet rs = statement.executeQuery();
			if(!rs.next()  ) {
				logger.error("No pending student!!!");
			}
			else {
			do {
				Student student = new Student();
				student.setUserID(rs.getString(1));
				student.setName(rs.getString(2));
				student.setStudentID(rs.getInt(4));
				student.setDepartment(rs.getString(5));
				student.setJoiningYear(rs.getInt(6));
				student.setPassword(rs.getString(7));
				student.setContactNumber(rs.getString(8));
				pendingStudents.add(student);
			}while(rs.next());
			}	
				
		} catch (SQLException e) {
//			logger.error(e.getMessage());
		}
		return pendingStudents;
	}

	@Override
	public void approveStudentAccount(int studentId) {
		
		Connection connection = DBUtil.getConnection();
		
		try {
			statement = connection.prepareStatement(SQLQueries.APPROVE_STUDENT_ACCOUNT(studentId));
						
			statement.executeUpdate();
			
			System.out.println("Student ID: "+studentId+" Approved !");
				
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}
	}

}