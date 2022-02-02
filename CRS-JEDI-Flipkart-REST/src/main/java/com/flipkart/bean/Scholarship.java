/**
 * 
 */
package com.flipkart.bean;

/**
 * @author Dell
 *
 */
public class Scholarship extends Payment {
	private String scholarshipName;

	public Scholarship() {
		// TODO Auto-generated constructor stub
		scholarshipName = "Default";
	}
	
	/**
	 * @param scholarshipName
	 */
	public Scholarship(String scholarshipName) {
		super();
		this.scholarshipName = scholarshipName;
	}

}
