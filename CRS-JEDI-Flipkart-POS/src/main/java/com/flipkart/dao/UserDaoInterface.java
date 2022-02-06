package com.flipkart.dao;

import com.flipkart.exception.UserNotFoundException;

import java.sql.SQLException;

/**
 * @author Dell
 *
 */
public interface UserDaoInterface {

	/**
	 * @param userID
	 * @param password
	 * @throws UserNotFoundException
	 */
	void updateProfPassword(String userID, String password) throws UserNotFoundException;

	/**
	 * @param userID
	 * @param password
	 */
	void updateAdminPassword(String userID, String password) throws UserNotFoundException;

	/**
	 * @param userID
	 * @param password
	 */
	void updateStudentPassword(String userID, String password) throws UserNotFoundException;

	/**
	 * @param userID
	 * @return
	 * @throws UserNotFoundException
	 */
	String getUserRole(String userID) throws UserNotFoundException;

	/**
	 * @param userID
	 * @param number
	 */
	void updateContactNumber(String userID, String number) throws UserNotFoundException;

	/**
	 * @param userID
	 * @param password
	 * @param role
	 * @return
	 * @throws SQLException
	 */
	boolean loginUser(String userID, String password, String role) throws SQLException;
}
