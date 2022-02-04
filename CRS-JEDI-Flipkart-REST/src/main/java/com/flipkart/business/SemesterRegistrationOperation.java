/**
 * 
 */
package com.flipkart.business;


import com.flipkart.bean.Course;
import com.flipkart.bean.Notification;
import com.flipkart.bean.SemesterRegistration;
import com.flipkart.dao.SemesterRegistrationDaoInterface;
import com.flipkart.dao.SemesterRegistrationDaoOperation;
import com.flipkart.exception.*;
import org.apache.log4j.Logger;

import java.util.ArrayList;


/**
 * @author Asus
 *
 */
public class SemesterRegistrationOperation implements SemesterRegistrationInterface{
	
	private static volatile SemesterRegistrationOperation instance = null;
	private static final Logger logger = Logger.getLogger(SemesterRegistration.class);
	SemesterRegistrationDaoInterface srdo = SemesterRegistrationDaoOperation.getInstance();

	private SemesterRegistrationOperation() {
	}

	/**
	 * Method to make Registration Operation Singleton
	 * 
	 * @return
	 */
	public static SemesterRegistrationOperation getInstance() {
		if (instance == null) {
			synchronized (SemesterRegistrationOperation.class) {
				instance = new SemesterRegistrationOperation();
			}
		}
		return instance;
	}

	@Override
	public boolean addCourse(int studentId, int semesterId, String courseId, boolean isPrimary)throws Exception,CourseExistsInCartException {

		try {

			return srdo.addCourse(studentId, semesterId, courseId, isPrimary);

		} catch (Exception e) {
			throw e;
		}
		catch(CourseExistsInCartException e) {
			throw e;
		}
		
	}

	@Override
	public boolean dropCourse(int studentId, int semesterId, String courseId) throws Throwable{

		try {

			return srdo.dropCourse(studentId, semesterId, courseId);

		} catch (CourseNotFoundException | CourseNotInCart e) {
			throw e;
		}
	}

	@Override
	public ArrayList<Course> viewAvailableCourses() throws Exception {

		try {

			ArrayList<Course> courseCatalog = srdo.viewAvailableCourses();
			if(courseCatalog == null) {
				throw new Exception("Error encountered while retrieving course catalog");
			}

			return srdo.viewAvailableCourses();

		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public boolean finishRegistration(int studentId, int semesterId)throws Exception, Throwable {

		try {

			Boolean val = srdo.finishRegistration(studentId, semesterId);
			NotificationInterface notificationObj = new NotificationOperation();
			notificationObj.sendPayFeesNotification();
			return val;

		} catch (InvalidSemesterRegistration e) {
			throw e;
		} catch (PaymentDoneException e) {
			throw e;
		}
		
	}
}
