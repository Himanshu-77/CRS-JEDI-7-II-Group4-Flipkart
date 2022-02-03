package com.flipkart.dao;

import com.flipkart.exception.InvalidRoleException;
import com.flipkart.exception.LoginFailedException;
import com.flipkart.exception.UserNotFoundException;

import java.sql.SQLException;

/**
 * @author Dell
 *
 */
public interface UserDaoInterface {

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
	/**
	 * @param userID
	 * @return
	 * @throws UserNotFoundException
	 */
	public String getUserRole(String userID) throws UserNotFoundException;

	/**
	 * @param userID
	 * @param number
	 */
	public void updateContactNumber(String userID, String number) throws UserNotFoundException;

	/**
	 * @param userID
	 * @param password
	 * @return
	 */

	public boolean loginUser(String userID, String password, String role) throws InvalidRoleException,UserNotFoundException,LoginFailedException,Exception,SQLException;
}
