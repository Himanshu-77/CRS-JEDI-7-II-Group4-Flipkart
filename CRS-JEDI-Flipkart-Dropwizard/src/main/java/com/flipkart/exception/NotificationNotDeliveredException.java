/**
 * 
 */
package com.flipkart.exception;

/**
 * @author Asus
 *
 */
public class NotificationNotDeliveredException extends Exception {

	public String getMessage() {
		return "Notification Not Delivered!";
	}
}
