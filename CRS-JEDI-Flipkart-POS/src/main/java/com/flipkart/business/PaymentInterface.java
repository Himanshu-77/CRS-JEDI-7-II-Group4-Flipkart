/**
 * 
 */
package com.flipkart.business;

import com.flipkart.bean.Payment;
import com.flipkart.exception.PaymentFailedException;

/**
 * @author Jayanth
 *
 */
public interface PaymentInterface {
	//Deuplicate in semester registration
//	/**
//	 * @param studentId : student to be notified
//	 * @param registeredCourses : has coursesList of student
//	 * @return : final payableAmount for student
//	 */
//	public float calculatePay(int studentId,RegisteredCourses registeredCourses);


	/**
	 * @param payment
	 * @return
	 * @throws PaymentFailedException
	 */
	public void makePayment(Payment payment);
	
}
