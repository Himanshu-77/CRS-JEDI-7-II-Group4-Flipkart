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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;


/**
 * @author Asus
 *
 */
public class SemesterRegistrationOperation implements SemesterRegistrationInterface{
	
	private static volatile SemesterRegistrationOperation instance = null;
	private static final Logger logger = LogManager.getLogger(SemesterRegistration.class);
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
	public boolean addCourse(int studentId, int semesterId, String courseId, boolean isPrimary) {

		try {

			return srdo.addCourse(studentId, semesterId, courseId, isPrimary);

		} catch (CourseNotFoundException | CourseSeatsUnavailableException | CourseExistsInCartException e) {
			logger.error(e.getMessage());
		}
		return false;
	}

	@Override
	public boolean dropCourse(int studentId, int semesterId, String courseId) {

		try {

			return srdo.dropCourse(studentId, semesterId, courseId);

		} catch (CourseNotFoundException | CourseNotInCart e) {
			logger.error(e.getMessage());
		}
		return false;
	}

	@Override
	public ArrayList<Course> viewAvailableCourses() {

		try {

			ArrayList<Course> courseCatalog = srdo.viewAvailableCourses();
			if(courseCatalog == null) {
				throw new Exception("Error encountered while retrieving course catalog");
			}

			return srdo.viewAvailableCourses();

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	@Override
	public boolean finishRegistration(int studentId, int semesterId) {

		try {

			Boolean val = srdo.finishRegistration(studentId, semesterId);
			Notification obj = new Notification();
			obj.showRegistrationNotification();
			return val;

		} catch (InvalidSemesterRegistration e) {
			logger.error(e.getMessage());
		} catch (PaymentDoneException e) {
			logger.error(e.getMessage());
			return true;
		}
		return false;
	}
}
