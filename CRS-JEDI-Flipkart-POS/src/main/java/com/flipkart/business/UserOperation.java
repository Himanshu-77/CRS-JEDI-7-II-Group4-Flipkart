package com.flipkart.business;

import com.flipkart.dao.UserDaoOperation;
import com.flipkart.exception.UserNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserOperation implements UserInterface{

	private static final Logger logger = LogManager.getLogger(UserOperation.class);
	private final UserDaoOperation userDao = UserDaoOperation.getInstance();

	@Override
	public void updatePassword(String userID, String password) {

		try {
			userDao.updatePassword(userID, password);
		} catch (UserNotFoundException e) {
			logger.error(e.getMessage());
		}
	}

	@Override
	public void updateContactNumber(String userID, String number) {

		try {
			userDao.updateContactNumber(userID, number);
		} catch (UserNotFoundException e) {
			logger.error(e.getMessage());
		}
	}

	@Override
	public void updateRole(String userID, String role) {
		// TODO Auto-generated method stub
		
	}

	public String getRole(String userID) {

		try {
			return userDao.getUserRole(userID);
		} catch (UserNotFoundException e) {
			logger.error(e.getMessage());
		}

		return null;
	}

	@Override

	public boolean loginUser(String userID, String password, String role) throws UserNotFoundException {
		
		return userDao.loginUser(userID, password, role);
	}

}
