
package com.flipkart.dao;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.ReportCard;
import com.flipkart.bean.Student;
import com.flipkart.business.StudentOperation;
import com.flipkart.constants.SQLQueries;
import com.flipkart.constants.constants;
import com.flipkart.exception.CourseAlreadyPresentException;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.FeesPendingException;
import com.flipkart.exception.ProfessorNotFoundException;
import com.flipkart.exception.ProfessorNotRegisteredException;
import com.flipkart.exception.StudentNotApprovedException;
import com.flipkart.exception.UsernameTakenException;
import com.flipkart.utils.DBUtil;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * @author Dell
 *
 */
public class AdminDaoOperation implements AdminDaoInterface {
	
	private PreparedStatement statement = null;

	private static volatile AdminDaoOperation instance = null;
	private static final Logger logger = Logger.getLogger(AdminDaoOperation.class);


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
	public void enableFeePaymentWindow(int semesterId) throws SQLException {

			Connection conn = DBUtil.getConnection();
			PreparedStatement queryStatement = conn.prepareStatement(SQLQueries.CHANGE_PAYMENT_WINDOW_STATUS);
			queryStatement.setString(1, "1");
			queryStatement.setString(2, Integer.toString(semesterId));
			queryStatement.executeUpdate();
			System.out.println("******* Payment Window Opened Successfully for Semester "+ semesterId +" ********");

	}

	@Override
	public void approveStudentRegistration(int studentId,int semesterId) throws FeesPendingException, StudentNotApprovedException {
		
		Connection connection = DBUtil.getConnection();

		try {
			statement = connection.prepareStatement(SQLQueries.GET_COURSES_BY_STUDENT_ID);
			statement.setInt(1, studentId);
			statement.setInt(2, semesterId);
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
				} while(rs.next());
			
				if(!fees) {
					throw new FeesPendingException(studentId);
				}
			
				if( primary_course_ids.size()  + alternate_course_ids.size() < 4) {
					throw new StudentNotApprovedException(studentId);
				}
			
				PreparedStatement update_statement = connection.prepareStatement(SQLQueries.APPROVE_STUDENT);
				update_statement.setInt(1, studentId);
				update_statement.setInt(2, semesterId);

				update_statement.executeUpdate();
				System.out.println("Approved");
			}

		} catch (SQLException e) {
			logger.error(e.getMessage());
		}

	}

	@Override
	public void addProfessor(Professor professor) throws Exception{
		// TODO Auto-generated method stub

		String sql = SQLQueries.ADMIN_ADD_PROFESSOR;

		Connection connection = DBUtil.getConnection();
		
		try {
			
			PreparedStatement preparedStatement0 = connection.prepareStatement(SQLQueries.GET_MAX_PROFESSOR_ID);
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

			throw new UsernameTakenException();
		}
	}

	@Override
	public void removeProfessor(int professorID) throws ProfessorNotRegisteredException,Exception{
		// TODO Auto-generated method stub

		String sql = SQLQueries.ADMIN_REMOVE_PROFESSOR;

		Connection connection = DBUtil.getConnection();
		
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, professorID);
			
			int row = statement.executeUpdate();
			if(row==0) {
				throw new ProfessorNotFoundException(professorID);
			}
			else {
			
				System.out.println(row + " user deleted.");
			}
			
			
		} catch (SQLException e) {
			throw e;
		}
	}

	@Override
	public ReportCard generateReportCard(int studentID) throws Exception {

		Connection connection = DBUtil.getConnection();
		ReportCard R = new ReportCard();
		
		try {
			statement = connection.prepareStatement(SQLQueries.GET_STUDENT);
			statement.setInt(1, studentID);
			ResultSet rs = statement.executeQuery();
			rs.next();
			if(rs.getBoolean(1)) {

				StudentOperation so = new StudentOperation();
				R = so.viewReportCard(studentID, constants.SemesterID);
				
				PreparedStatement statement1 = connection.prepareStatement(SQLQueries.GENERATE_REPORT_CARD);
				statement1.setFloat(1, R.getSpi());
				statement1.setInt(2, studentID);

				statement1.executeUpdate();
			}
			
			else {
				throw new StudentNotApprovedException(studentID);
			}
			
		} catch (Exception e) {
			throw e;
		}
		return R;
	}

	@Override
	public void removeCourse(String courseID) throws Exception {

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

				// Update legacy course catalog
				PreparedStatement queryStatement = connection.prepareStatement(SQLQueries.REMOVE_COURSE_BY_ID);
				queryStatement.setString(1, courseID);
				queryStatement.executeUpdate();

				System.out.println(row + " course deleted.");
			}
			
			
		} catch (SQLException e) {
			throw e;
		}
		
	}

	@Override
	public void addCourse(Course course) throws Exception {

		String sql = SQLQueries.ADMIN_ADD_COURSE;
		Connection connection = DBUtil.getConnection();
		
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, course.getCourseID());
			statement.setString(2, course.getCoursename());
			statement.setInt(3, course.getOfferedSemester());
			statement.setInt(4, course.getAvailableSeats());
			
			int row = statement.executeUpdate();

			PreparedStatement queryStatement;
			queryStatement = connection.prepareStatement(SQLQueries.ADD_COURSE_BY_ID);
			queryStatement.setString(1,  course.getCourseID());
			queryStatement.setString(2, course.getCoursename());
			queryStatement.executeUpdate();

			System.out.println(row + " course added.");
			
		} catch (SQLException e) {
			throw new CourseAlreadyPresentException(course.getCourseID());
		}
		
	}

	
	@Override
	public HashMap<String,ArrayList<Integer> >  viewCourseStudentList(String courseID, int semesterId, Boolean viewAll) throws Exception {
		
		Connection connection = DBUtil.getConnection();
		HashMap<String,ArrayList<Integer> > StudentList = new HashMap<String,ArrayList<Integer> >();
		 
		try {

			List<String> course_ids = new ArrayList<String>();
			
			if(viewAll) {
				statement = connection.prepareStatement(SQLQueries.GET_ALL_COURSES);
				statement.setInt(1, semesterId);
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
				PreparedStatement statement2 = connection.prepareStatement(SQLQueries.GET_COURSE_STUDENTS);
				statement2.setString(1, c);
				statement2.setInt(2, semesterId);
				ResultSet studentSet= statement2.executeQuery();
				studentSet.next();
				ArrayList<Integer> CourseStudentList = new ArrayList<Integer>();
				do {					
					CourseStudentList.add(studentSet.getInt(1));
				}while(studentSet.next());
				StudentList.put(c,CourseStudentList);
			}

		} catch (SQLException e) {
			throw new CourseNotFoundException(courseID);
		}
		return StudentList;
	
	}

	@Override
	public List<Student> getPendingStudentAccountsList() throws Exception {
		
		Connection connection = DBUtil.getConnection();
		List<Student> pendingStudents = new ArrayList<Student>();
		
		try {
			statement = connection.prepareStatement(SQLQueries.GET_PENDING_STUDENT);
						
			ResultSet rs = statement.executeQuery();
			if(!rs.next()  ) {
				throw new Exception("No pending student!!!");
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
			throw e;
		}
		return pendingStudents;
	}

	@Override
	public void approveStudentAccount(int studentId) throws Exception {
		
		Connection connection = DBUtil.getConnection();
		
		try {
			statement = connection.prepareStatement(SQLQueries.APPROVE_STUDENT_ACCOUNT);
			statement.setInt(1, studentId);
			statement.executeUpdate();
			
			System.out.println("Student ID: " + studentId + " Approved !");
				
		} catch (SQLException e) {
			
			throw new Exception ("Invalid Student ID");
		}
	}

}