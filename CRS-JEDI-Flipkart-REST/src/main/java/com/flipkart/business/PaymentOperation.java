/**
 * 
 */
package com.flipkart.business;

import com.flipkart.bean.Notification;
import com.flipkart.bean.Payment;
import com.flipkart.dao.PaymentDaoInterface;
import com.flipkart.dao.PaymentDaoOperation;
import com.flipkart.exception.PaymentDoneException;
import com.flipkart.exception.PaymentFailedException;
import org.apache.log4j.Logger;

/**
 * @author Aeron
 *
 */
public class PaymentOperation implements PaymentInterface{

	private static final Logger logger = Logger.getLogger(PaymentOperation.class);

	@Override
	public void makePayment(Payment payment) {

		try {
			PaymentDaoInterface paymentObj = new PaymentDaoOperation();
			paymentObj.makePayment(payment);

			/*
			Notification obj = new Notification();
			obj.showPaymentNotification(Integer.toString(payment.getStudentID()));
			 */

		} catch (PaymentFailedException e) {
			logger.error(e.getMessage());
		} catch (PaymentDoneException e) {
			logger.error(e.getMessage());
		}
	}

}
