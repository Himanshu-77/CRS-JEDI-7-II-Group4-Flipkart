package com.flipkart.dao;

import com.flipkart.exception.UserNotFoundException;

import java.sql.SQLException;

/**
 * @author rutwi
 *
 */
public interface UserDaoInterface {
	
	/**
	 * @param userID
	 * @param password
	 */
	public void updatePassword(String userID, String password) throws UserNotFoundException;

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

	public boolean loginUser(String userID, String password, String role) throws SQLException;
}
