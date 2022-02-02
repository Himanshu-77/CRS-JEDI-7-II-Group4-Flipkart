/**
 * 
 */
package com.flipkart.dao;

import com.flipkart.bean.Payment;
import com.flipkart.exception.PaymentDoneException;
import com.flipkart.exception.PaymentFailedException;

/**
 * @author Dell
 *
 */
public interface PaymentDaoInterface {

	/**
	 * @param payment
	 */
    public void makePayment(Payment payment) throws PaymentFailedException, PaymentDoneException;
}
