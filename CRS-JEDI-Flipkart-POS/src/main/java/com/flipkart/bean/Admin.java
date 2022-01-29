package com.flipkart.bean;

/**
 * @author Dell
 *
 */
public class Admin extends User {
	private String dateOfJoining;

	public Admin() {
		// TODO Auto-generated constructor stub
		this.dateOfJoining="01-01-2001";//default value of DOJ
	}

	public Admin(String dateOfJoining) {
		super();
		this.dateOfJoining = dateOfJoining;
	}

	public String getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(String dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	
}
