/**
 * 
 */
package com.flipkart.exception;

/**
 * @author Aeron
 * Exception arises when login attempted with wrong username.
 */
public class UserNotFoundException extends Exception {
	
	private String userId;

	/**
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * Message thrown by user
	 */
	@Override
	public String getMessage() {
		return "No such user exists! Verify userID and try again ";
	}
	
}
