/**
 * 
 */
package com.flipkart.business;

/**
 * @author Dell
 *
 */
public interface NotificationInterface{
	
	
	 public void sendPayFeesNotification();
	 
	 public void sendPaymentCompleteNotification(int transactionId, int studentid);
	
}
