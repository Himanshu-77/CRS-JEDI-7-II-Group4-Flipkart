/**
 * 
 */
package com.flipkart.exception;

/**
 * @author Asus
 *
 */
public class PaymentFailedException extends Exception {
	
	public String getMessage() {
		return "Payment was not successful ! Please try again";
	}
}
