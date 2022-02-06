/**
 * 
 */
package com.flipkart.business;

import com.flipkart.exception.UserNotFoundException;

/**
 * @author Dell
 *
 */
public interface UserInterface {
	
	/**
	 * Update login password for professor account.
	 * @param userID
	 * @param password
	 */
	void updateProfPassword(String userID, String password) throws UserNotFoundException;

	/**
	 * Update login password for admin account.
	 * @param userID
	 * @param password
	 */
	void updateAdminPassword(String userID, String password) throws UserNotFoundException;

	/**
	 * Update login password for student account.
	 * @param userID
	 * @param password
	 */
	void updateStudentPassword(String userID, String password) throws UserNotFoundException;
	
	/**
	 * Update contact details for provided user-id.
	 * @param userID
	 * @param number
	 */
	void updateContactNumber(String userID, String number) throws UserNotFoundException;
	
	/**
	 * Update role for provided user-id.
	 * @param userID
	 * @param role
	 */
	void updateRole(String userID, String role) throws UserNotFoundException;
	
	/**
	 * Login user.
	 * @param userID
	 * @param password
	 * @return the status if a user is successfully logged-in.
	 */
	boolean loginUser(String userID, String password, String role) throws UserNotFoundException;
}
