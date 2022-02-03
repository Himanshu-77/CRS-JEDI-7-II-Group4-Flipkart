package com.flipkart.business;

import com.flipkart.dao.UserDaoOperation;
import com.flipkart.exception.InvalidRoleException;
import com.flipkart.exception.LoginFailedException;
import com.flipkart.exception.UserNotFoundException;

import java.sql.SQLException;

import org.apache.log4j.Logger;

public class UserOperation implements UserInterface{

	private static final Logger logger = Logger.getLogger(UserOperation.class);
	private final UserDaoOperation userDao = UserDaoOperation.getInstance();
	private static volatile UserOperation instance=null;

	
{
		
	}
	/**
	 * Method to make StudentOperation Singleton
	 * @return
	 */
	public static UserOperation getInstance()
	{
		if(instance==null)
		{
			// This is a synchronized block, when multiple threads will access this instance
			synchronized(UserOperation.class){
				instance=new UserOperation();
			}
		}
		return instance;
	}
	
	@Override
	public void updateStudentPassword(String userID, String password) {

		userDao.updateStudentPassword(userID, password);
	}

	@Override
	public void updateProfPassword(String userID, String password) {

		userDao.updateProfPassword(userID, password);

	}

	@Override
	public void updateAdminPassword(String userID, String password) {

		userDao.updateAdminPassword(userID, password);

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

	public boolean loginUser(String userID, String password, String role) throws InvalidRoleException,UserNotFoundException,LoginFailedException,Exception,SQLException {
		
		return userDao.loginUser(userID, password, role);
	}

}
