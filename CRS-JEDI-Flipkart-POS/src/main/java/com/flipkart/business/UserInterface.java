/**
 * 
 */
package com.flipkart.business;

import com.flipkart.exception.*;

/**
 * @author rutwi
 *
 */
public interface UserInterface {
	
	/**
	 * @param userID
	 * @param password
	 */

	public void updatePassword(String userID, String password) throws UserNotFoundException;
	
	/**
	 * @param userID
	 * @param number
	 */
	public void updateContactNumber(String userID, String number) throws UserNotFoundException;
	
	/**
	 * @param userID
	 * @param role
	 */
	public void updateRole(String userID, String role) throws UserNotFoundException;
	
	/**
	 * @param userID
	 * @param password
	 * @return
	 */
	public boolean loginUser(String userID, String password, String role) throws UserNotFoundException;
	

}
