package com.flipkart.dao;

import com.flipkart.exception.LoginFailedException;
import com.flipkart.exception.UserNotFoundException;
import com.flipkart.utils.DBUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class UserDaoOperation implements UserDaoInterface{

	private static final Logger logger = LogManager.getLogger(UserDaoOperation.class);
	private static volatile UserDaoOperation instance=null;
	private static final Connection conn = DBUtil.getConnection();
	private static final String[] roleList = {"professor", "student", "admin"};
	private String userRole;

	private UserDaoOperation(){

	}
	public static UserDaoOperation getInstance()
	{
		if(instance==null)
		{
			// This is a synchronized block, when multiple threads will access this instance
			synchronized(UserDaoOperation.class){
				instance=new UserDaoOperation();
			}
		}
		return instance;
	}

	public static void main(String[] args) throws UserNotFoundException {
		UserDaoInterface test = new UserDaoOperation();

//		test.updateStudentPassword("arkaprabha", "12345");
		test.updateProfPassword("Arka", "12345");
//		test.updateAdminPassword("admin", "admin");
//		test.updateContactNumber("aaa", "999");
		//System.out.println(test.loginUser("aaa", "bbb"));
	}



	@Override
	public void updateStudentPassword(String userID, String newPassword)  {

		PreparedStatement queryStatement;

		try {
			System.out.println("Updating password...");

			String query = "UPDATE student" + " SET password = ? WHERE user_name = ?";

			queryStatement = conn.prepareStatement(query);
			queryStatement.setString(1, newPassword);
			queryStatement.setString(2, userID);
			queryStatement.executeUpdate();

			System.out.println("Password Update Successful!");

		}
		catch (SQLException ex) {
			logger.error(ex.getMessage());
		}
	}

	@Override
	public void updateProfPassword(String userID, String newPassword)  {

		PreparedStatement queryStatement;

		try {
			System.out.println("Updating password...");


			String query = "UPDATE professor"  + " SET password = ? WHERE user_name = ?";

			queryStatement = conn.prepareStatement(query);
			queryStatement.setString(1, newPassword);
			queryStatement.setString(2, userID);
			queryStatement.executeUpdate();

			System.out.println("Password Update Successful!");


		}
		catch (SQLException ex) {
			logger.error(ex.getMessage());
		}
	}

	@Override
	public void updateAdminPassword(String userID, String newPassword)  {

		PreparedStatement queryStatement;

		try {
			System.out.println("Updating password...");

			String query = "UPDATE admin" + " SET password = ? WHERE user_name = ?";

			queryStatement = conn.prepareStatement(query);
			queryStatement.setString(1, newPassword);
			queryStatement.setString(2, userID);
			queryStatement.executeUpdate();

			System.out.println("Password Update Successful!");


		}
		catch (SQLException ex) {
			logger.error(ex.getMessage());
		}
	}



	@Override
	public String getUserRole(String userID) throws UserNotFoundException {

		if(userRole == null) {
			assignUserRole(userID);
		}

		return userRole;
	}

	private void assignUserRole(String userID) throws UserNotFoundException{

		PreparedStatement stmt;

		try {

			for(String role : roleList) {

				String query = "SELECT COUNT(1) FROM " + role + " WHERE user_name = ?";

				stmt = conn.prepareStatement(query);
				stmt.setString(1, userID);
				ResultSet rs = stmt.executeQuery();

				while(rs.next()) {
					if(rs.getInt("COUNT(1)") == 1) {
						userRole = role;
						break;
					}
				}

				if(userRole != null) break;
			}

			if(userRole == null) {
				throw new UserNotFoundException();
			}

		} catch (SQLException ex) {
			logger.error(ex.getMessage());
		}
	}

	@Override
	public void updateContactNumber(String userID, String newNumber) throws UserNotFoundException {

		PreparedStatement queryStatement;

		try {
			System.out.println("Updating contact number...");

			if(userRole == null) {
				assignUserRole(userID);
			}

			String query = "UPDATE " + userRole + " SET contact_number = ? WHERE user_name = ?";

			queryStatement = conn.prepareStatement(query);
			queryStatement.setString(1, newNumber);
			queryStatement.setString(2, userID);
			queryStatement.executeUpdate();


		}
		catch (SQLException ex) {
			logger.error(ex.getMessage());
		}
	}

	@Override
	public boolean loginUser(String userID, String userPassword, String role) {

		PreparedStatement queryStatement;

		try {
			System.out.println("Attempting to Log in...");
			

			String query = "SELECT password " + "FROM " + role + " WHERE user_name = ?";

			queryStatement = conn.prepareStatement(query);
			queryStatement.setString(1, userID);
			ResultSet rs = queryStatement.executeQuery();

			String password = null;
			while (rs.next()) {
				password = rs.getString("password");
			}

			if(password == null) {
				throw new UserNotFoundException();
			}

			if(password.equals(userPassword)) {
				
				if(role.equals("student"))
				{
					String query1 = "SELECT account_approved FROM student WHERE user_name = ?";
					queryStatement = conn.prepareStatement(query1);
					queryStatement.setString(1, userID);
					ResultSet rs1 = queryStatement.executeQuery();
					
					Boolean account_status = false;
					if(rs1.next())
					{
						account_status = rs1.getBoolean("account_approved");
						
					}
					
					if(!account_status)
					{
						throw new Exception("Account Not Approved By Admin");

					}
					
				}
				return true;
			}
			else{
				throw new LoginFailedException(userID);
			}

		}

		catch(LoginFailedException ex){
			System.out.println(ex.getMessage());
		}
		catch (UserNotFoundException ex) {
			System.out.println(ex.getMessage());
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		// throw exception on login failure
		return false;
	}

}
