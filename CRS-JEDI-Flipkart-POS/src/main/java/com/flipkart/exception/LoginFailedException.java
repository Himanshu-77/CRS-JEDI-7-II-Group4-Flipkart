/**
 * 
 */
package com.flipkart.exception;

/**
 * @author rutwi
 *
 */
public class LoginFailedException extends Exception {
	private String userID;
	
	public LoginFailedException(String userID)
	{
		this.userID = userID;
	}
	
	public String getMessage() {
		return "Login Failed for User ID: " + userID;
	}

}
