/**
 * 
 */
package com.flipkart.business;

import com.flipkart.bean.Payment;
import com.flipkart.dao.PaymentDaoInterface;
import com.flipkart.dao.PaymentDaoOperation;
import com.flipkart.exception.PaymentFailedException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Asus
 *
 */
public class PaymentOperation implements PaymentInterface{

	private static final Logger logger = LogManager.getLogger(PaymentOperation.class);

	@Override
	public void makePayment(Payment payment) {

		try {
			PaymentDaoInterface paymentObj = new PaymentDaoOperation();
			paymentObj.makePayment(payment);
		} catch (PaymentFailedException e) {
			logger.error(e.getMessage());
		}
	}

}
