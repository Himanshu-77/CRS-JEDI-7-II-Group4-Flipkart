/**
 * 
 */
package com.flipkart.business;

import com.flipkart.bean.Payment;
import com.flipkart.exception.PaymentFailedException;

/**
 * @author Aeron
 *
 */
public interface PaymentInterface {

	/**
	 * Pay fees.
	 * @param payment
	 */
	void makePayment(Payment payment);
	
}
