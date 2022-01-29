/**
 * 
 */
package com.flipkart.bean;

import java.util.ArrayList;

/**
 * @author Dell
 *
 */
public class RegisteredCourses {
	private Integer studentID;
	private Integer semesterID;
	private ArrayList<String> courseID = new ArrayList<String>();
	
	public RegisteredCourses() {
		// TODO Auto-generated constructor stub
		studentID = 0;
		semesterID = 1;
		
	}
	/**
	 * @param studentID
	 * @param semesterID
	 * @param courseID
	 */
	public RegisteredCourses(Integer studentID, Integer semesterID, ArrayList<String> courseID) {
		super();
		this.studentID = studentID;
		this.semesterID = semesterID;
		this.courseID = courseID;
	}
	/**
	 * @return the studentID
	 */
	public Integer getStudentID() {
		return studentID;
	}
	/**
	 * @param studentID the studentID to set
	 */
	public void setStudentID(Integer studentID) {
		this.studentID = studentID;
	}
	/**
	 * @return the semesterID
	 */
	public Integer getSemesterID() {
		return semesterID;
	}
	/**
	 * @param semesterID the semesterID to set
	 */
	public void setSemesterID(Integer semesterID) {
		this.semesterID = semesterID;
	}
	/**
	 * @return the courseID
	 */
	public ArrayList<String> getCourseID() {
		return courseID;
	}
	/**
	 * @param courseID the courseID to set
	 */
	public void setCourseID(ArrayList<String> courseID) {
		this.courseID = courseID;
	}
	
}
