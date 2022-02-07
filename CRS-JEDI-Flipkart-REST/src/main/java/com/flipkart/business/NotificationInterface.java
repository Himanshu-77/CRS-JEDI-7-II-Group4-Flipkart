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
	 *  Send payment pending notification
	 */
	public void sendPayFeesNotification();
	 
	/**
	 * Send payment complete notification
	 * @param transactionId
	 * @param studentid
	 */
	public void sendPaymentCompleteNotification(int transactionId, int studentid);
	
}
