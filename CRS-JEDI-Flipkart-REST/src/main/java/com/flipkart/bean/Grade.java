package com.flipkart.bean;

/**
 * @author Aeron
 *
 */
public class Grade {
	private int numericGrade;

	public Grade() {
		this.numericGrade=0;
	}
	public Grade(int grade) {
		super();
		this.numericGrade = grade;
	}
	public int getNumericGrade() {
		return numericGrade;
	}

	public void setNumericGrade(int numericGrade) {
		this.numericGrade = numericGrade;
	}
}
