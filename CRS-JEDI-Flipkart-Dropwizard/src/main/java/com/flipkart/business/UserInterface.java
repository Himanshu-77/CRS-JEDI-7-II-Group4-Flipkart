/**
 * 
 */
package com.flipkart.business;

import java.sql.SQLException;

import com.flipkart.exception.InvalidRoleException;
import com.flipkart.exception.LoginFailedException;
import com.flipkart.exception.UserNotFoundException;

/**
 * @author Dell
 *
 */
public interface UserInterface {
	
	/**
	 * @param userID
	 * @param password
	 */
	public void updateProfPassword(String userID, String password) throws UserNotFoundException;

	/**
	 * @param userID
	 * @param password
	 */
	public void updateAdminPassword(String userID, String password) throws UserNotFoundException;

	/**
	 * @param userID
	 * @param password
	 */
	public void updateStudentPassword(String userID, String password) throws UserNotFoundException;
	
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
	public boolean loginUser(String userID, String password, String role) throws InvalidRoleException,UserNotFoundException,LoginFailedException,Exception,SQLException;
	

}
