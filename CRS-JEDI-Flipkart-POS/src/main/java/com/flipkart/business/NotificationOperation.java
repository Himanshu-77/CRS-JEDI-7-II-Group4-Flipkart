/**
 * 
 */
package com.flipkart.business;

import com.flipkart.bean.Notification;
import com.flipkart.dao.NotificationDaoInterface;
import com.flipkart.dao.NotificationDaoOperation;
import com.flipkart.dao.PaymentDaoInterface;
import com.flipkart.dao.PaymentDaoOperation;

/**
 * @author Dell
 *
 */
public class NotificationOperation implements NotificationInterface{

	@Override
	public void sendPayFeesNotification() {
		Notification obj = new Notification();
		obj.showRegistrationNotification();
//		System.out.println("+-----------------------------------+");
//		System.out.println("|         Notification Alert!       |");
//		System.out.println("+-----------------------------------+");
//		System.out.println("|      Registration Completed!      |");
//		System.out.println("|    Please Complete Fee Payment!   |");
//		System.out.println("+-----------------------------------+");
		
	}

	@Override
	public void sendPaymentCompleteNotification(int transactionId, int studentid) {


		NotificationDaoInterface notificationObj = new NotificationDaoOperation();
		notificationObj.sendPaymentCompleteNotification(transactionId, studentid);
		Notification obj = new Notification();
		obj.showPaymentNotification(Integer.toString(studentid),Integer.toString(transactionId));


	}

}
