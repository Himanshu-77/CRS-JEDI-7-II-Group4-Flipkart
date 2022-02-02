/**
 * 
 */
package com.flipkart.dao;

import com.flipkart.bean.Payment;
import com.flipkart.business.NotificationInterface;
import com.flipkart.business.NotificationOperation;
import com.flipkart.constants.SQLQueries;
import com.flipkart.exception.PaymentDoneException;
import com.flipkart.exception.PaymentFailedException;
import com.flipkart.utils.DBUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Dell
 *
 */
public class PaymentDaoOperation implements PaymentDaoInterface{

	private static final Logger logger = LogManager.getLogger(PaymentDaoOperation.class);
	private static volatile PaymentDaoOperation instance=null;
	private final Connection connection=DBUtil.getConnection();
	
	/*
	public static void main(String[] args) throws SQLException {
		PaymentDaoOperation test = new PaymentDaoOperation();
		test.makePayment();
	}
	 */
	
	@Override
	public void makePayment(Payment payment) throws PaymentFailedException,PaymentDoneException {

		try {

			PreparedStatement statement, stmt2;

			stmt2 = connection.prepareStatement(SQLQueries.PAYMENT_STATUS_STUDENT, ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			stmt2.setString(1, Integer.toString(payment.getStudentID()));
			ResultSet rs2 = stmt2.executeQuery();

			if(rs2.next()==true){
				throw new PaymentDoneException();

			}
			else {
				int newID = getNewTransactionID();

				if (newID == -1) {
					throw new SQLException();

				}

				payment.setPaymentID(newID);

				String sql = SQLQueries.MAKE_PAYMENT;
				String query = SQLQueries.UPDATE_STUDENT_PAYMENT_STATUS;

				statement = connection.prepareStatement(sql);

				payment.setPaymentStatus(true);
				payment.setAmount(1000);

				statement.setInt(1, payment.getStudentID());
				statement.setInt(2, payment.getAmount());
				statement.setInt(3, payment.getPaymentID());
				statement.setString(4, payment.getPaymentMode());
				statement.setBoolean(5, payment.getPaymentStatus());

				statement.executeUpdate();

				PreparedStatement statement2 = connection.prepareStatement(query);
				statement2.setInt(1, payment.getStudentID());
				statement2.executeUpdate();

				// Generate Notification
				NotificationInterface notificationObj = new NotificationOperation();
				notificationObj.sendPaymentCompleteNotification(newID,payment.getStudentID());

			}
		}
			catch (SQLException e) {
			throw new PaymentFailedException();

		}
	}

	private int getNewTransactionID() {

		int newTransactionID = -1;

		try
		{
			PreparedStatement stmt = connection.prepareStatement(SQLQueries.GET_MAX_TRANSACTION_ID, ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery();
				while(rs.next()) {
					newTransactionID = rs.getInt("MAX(transactionId)") + 1;
			}

		}
		catch(Exception ex) {
			logger.error(ex.getMessage());
		}

		return newTransactionID;
	}

	public static PaymentDaoOperation getInstance()
	{
		if(instance==null)
		{
			// This is a synchronized block, when multiple threads will access this instance
			synchronized(PaymentDaoOperation.class){
				instance = new PaymentDaoOperation();
			}
		}
		return instance;
	}

}