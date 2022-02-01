/**
 * 
 */
package com.flipkart.dao;

import com.flipkart.bean.Notification;
import com.flipkart.bean.Payment;

import java.sql.SQLException;

/**
 * @author Dell
 *
 */
public interface NotificationDaoInterface{
	
	
	 /**
	  * @param studentid : student to be notified
	  * @param transactionID: payment transaction ID
	  * @return Boolean status
	  */
	 public Boolean sendPaymentCompleteNotification(int transactionID, int studentid);
	


	
}
