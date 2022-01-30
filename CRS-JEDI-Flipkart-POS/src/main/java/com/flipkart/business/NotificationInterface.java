/**
 * 
 */
package com.flipkart.business;

/**
 * @author Jayanth
 *
 */
public interface NotificationInterface{
	
	
	 public void sendPayFeesNotification();
	 
	 public void sendPaymentCompleteNotification(int amount, int studentid);
	
}
