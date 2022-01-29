/**
 * 
 */
package com.flipkart.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Dell
 *
 */
public class ReportCard {
	HashMap<String, Integer> grades =new HashMap<String, Integer>();
	private Float spi;
	private Integer studentID;
	private Integer semesterID;
	private Boolean isVisible;
	
	
	public ReportCard() {
		// TODO Auto-generated constructor stub
		spi = (float) 0.0;
		studentID = -1;
		semesterID = 1;
		isVisible = false;
	}
	
	/**
	 * @param grades
	 * @param spi
	 * @param studentID
	 * @param semesterID
	 * @param isVisible
	 */
	public ReportCard(HashMap<String, Integer> grades, Float spi, Integer studentID, Integer semesterID,
			Boolean isVisible) {
		super();
		this.grades = grades;
		this.spi = spi;
		this.studentID = studentID;
		this.semesterID = semesterID;
		this.isVisible = isVisible;
	}

	/**
	 * @return the grades
	 */
	public HashMap<String, Integer> getGrades() {
		return grades;
	}

	/**
	 * @param grades the grades to set
	 */
	public void setGrades(HashMap<String, Integer> grades) {
		this.grades = grades;
	}

	/**
	 * @return the spi
	 */
	public Float getSpi() {
		return spi;
	}

	/**
	 * @param spi the spi to set
	 */
	public void setSpi(Float spi) {
		this.spi = spi;
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
	 * @return the isVisible
	 */
	public Boolean getIsVisible() {
		return isVisible;
	}

	/**
	 * @param isVisible the isVisible to set
	 */
	public void setIsVisible(Boolean isVisible) {
		this.isVisible = isVisible;
	} 
	
	

}
