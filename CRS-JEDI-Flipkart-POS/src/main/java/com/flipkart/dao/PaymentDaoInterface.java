/**
 * 
 */
package com.flipkart.dao;

import com.flipkart.bean.Payment;
import com.flipkart.exception.PaymentDoneException;
import com.flipkart.exception.PaymentFailedException;

/**
 * @author Jayanth
 *
 */
public interface PaymentDaoInterface {
	//Deuplicate in semester registration
//	/**
//	 * @param studentId : student to be notified
//	 * @param registeredCourses : has coursesList of student
//	 * @return : final payableAmount for student
//	 */
//	public float calculatePay(int studentId,RegisteredCourses registeredCourses);


	/**
	 * @param payment
	 */
    public void makePayment(Payment payment) throws PaymentFailedException, PaymentDoneException;
}
