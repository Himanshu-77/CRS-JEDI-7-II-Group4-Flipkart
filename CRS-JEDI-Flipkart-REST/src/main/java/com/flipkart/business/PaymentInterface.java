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
	 *
	 * @param payment
	 */
	public void makePayment(Payment payment)throws Exception;
	
}
