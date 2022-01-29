/**
 * 
 */
package com.flipkart.business;


import java.util.ArrayList;

import com.flipkart.bean.Course;
import com.flipkart.bean.SemesterRegistration;
import com.flipkart.exception.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * @author Dell
 *
 */
public class SemesterRegistrationOperation implements SemesterRegistrationInterface{
	private static volatile SemesterRegistrationOperation instance = null;
	private static final Logger logger = LogManager.getLogger(SemesterRegistration.class);

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


		return true;
	}

	@Override
	public boolean dropCourse(int studentId, int semesterId, String courseId) {

		return true;
	}

	@Override
	public ArrayList<Course> viewAvailableCourses() {
		ArrayList<Course> courseCatalog = new ArrayList<>();

		return courseCatalog;
	}

	@Override
	public boolean finishRegistration(int studentId, int semesterId) {
		return true;
	}
}
