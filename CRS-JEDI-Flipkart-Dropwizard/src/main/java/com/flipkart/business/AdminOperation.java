package com.flipkart.business;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.ReportCard;
import com.flipkart.bean.Student;
import com.flipkart.dao.AdminDaoInterface;
import com.flipkart.dao.AdminDaoOperation;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.FeesPendingException;
import com.flipkart.exception.ProfessorNotAddedException;
import com.flipkart.exception.ProfessorNotRegisteredException;
import com.flipkart.exception.StudentNotApprovedException;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Aeron
 *
 */

public class AdminOperation implements AdminInterface {

	private static volatile AdminOperation instance = null;
	private static final Logger logger = Logger.getLogger(AdminOperation.class);
	
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

	AdminDaoInterface ado  = AdminDaoOperation.getInstance();

	@Override
	public void enableFeePayment(int semesterId) throws Exception  {

		try {
			ado.enableFeePaymentWindow(semesterId);
		}
		catch (SQLException e) {
			throw e;
		}
	}

	@Override
	public void approveStudentRegistration(int studentId,int semesterId) throws Exception {

		try {
			ado.approveStudentRegistration(studentId,semesterId);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void addProfessor(Professor professor) throws Exception{

		try {
			ado.addProfessor(professor);
		} catch (Exception e) {
			throw new ProfessorNotAddedException();
		}
	}

	@Override
	public void removeProfessor(int professorID) throws Exception {
		try {
		
			ado.removeProfessor(professorID);
		}
		catch(ProfessorNotRegisteredException e) {
			throw e;
		}
	}

	@Override
	public void removeCourse(String courseID) throws Exception {

		try {

			ado.removeCourse(courseID);

		}

		catch(Exception e) {
			throw e;
		}
	}
	

	@Override
	public void addCourse(String course_name, String courseID, int semester) throws Exception{
		try {
			Course newCourse = new Course();
			newCourse.setCoursename(course_name);
			newCourse.setCourseID(courseID);
			newCourse.setOfferedSemester(semester);
			newCourse.setAvailableSeats(10);
			ado.addCourse(newCourse);

		}
		catch(Exception e) {
			throw e;
		}
		
		
	}

	
	@Override
	public HashMap<String,ArrayList<Integer> > viewCourseStudentList(String courseID, int semester, Boolean viewAll)  throws Exception{

		try {
			return ado.viewCourseStudentList(courseID,semester,viewAll);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public ReportCard generateReportCard(int studentID) throws Exception{

		ReportCard R = new ReportCard();
		try {

			R= ado.generateReportCard(studentID);

		} catch (Exception e) {
			throw e;
		}
		return R;
	}

	
	@Override
	public List<Student> getPendingStudentAccountsList() throws Exception {

		try {
			return ado.getPendingStudentAccountsList();
		} catch (Exception e) {
			throw e;
		}
		
	}

	@Override
	public void approveStudentAccount(Integer studentID) throws Exception {
		try {
			ado.approveStudentAccount(studentID);
		}
		catch(Exception e) {
			throw e;
		}
		
		
	}
}