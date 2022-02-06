/**
 * 
 */
package com.flipkart.business;

/**
 * @author Dell
 *
 */
public interface NotificationInterface{

	/**
	 * Display pay fees notification to student when semester registration is completed.
	 */
	void sendPayFeesNotification();

	/**
	 * Display a notification denoting that payment is completed.
	 * @param transactionId
	 * @param studentid
	 */
	void sendPaymentCompleteNotification(int transactionId, int studentid);
	
}
