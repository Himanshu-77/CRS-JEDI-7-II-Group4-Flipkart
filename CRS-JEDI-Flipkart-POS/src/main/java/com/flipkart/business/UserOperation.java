package com.flipkart.business;

import com.flipkart.exception.UserNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserOperation implements UserInterface{

	private static final Logger logger = LogManager.getLogger(UserOperation.class);

	@Override
	public void updatePassword(String userID, String password) {


	}

	@Override
	public void updateContactNumber(String userID, String number) {


	}

	@Override
	public void updateRole(String userID, String role) {

		
	}

	public String getRole(String userID) {



		return null;
	}

	@Override

	public boolean loginUser(String userID, String password, String role) throws UserNotFoundException {
		
		return true;
	}

}
