/**
 * 
 */
package com.flipkart.bean;

/**
 * @author Dell
 *
 */
public class SemesterRegistration {
	private Integer studentID;
	private Integer semesterID;
	private String dateOfRegistration;
	private Boolean isApproved;
	
	public SemesterRegistration() {
		// TODO Auto-generated constructor stub
		studentID = 0;
		semesterID = 1;
		dateOfRegistration = "1/1/2021";
	}
	
	public SemesterRegistration(Integer studentID, Integer semesterID, String dateOfRegistration, Boolean isApproved) {
		super();
		this.studentID = studentID;
		this.semesterID = semesterID;
		this.dateOfRegistration = dateOfRegistration;
		this.isApproved = isApproved;
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
	 * @return the dateOfRegistration
	 */
	public String getDateOfRegistration() {
		return dateOfRegistration;
	}

	/**
	 * @param dateOfRegistration the dateOfRegistration to set
	 */
	public void setDateOfRegistration(String dateOfRegistration) {
		this.dateOfRegistration = dateOfRegistration;
	}

	/**
	 * @return the isApproved
	 */
	public Boolean getIsApproved() {
		return isApproved;
	}

	/**
	 * @param isApproved the isApproved to set
	 */
	public void setIsApproved(Boolean isApproved) {
		this.isApproved = isApproved;
	}
	
}
