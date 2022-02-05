package com.flipkart.validator;

import com.flipkart.bean.Course;
import com.flipkart.exception.CourseNotFoundException;

import java.util.List;

public class StudentValidator {

    /**
     * Method to check if Contact details are valid
     * @param contact: Contact details of Student
     * @return true, if Contact details is valid. else, false.
     */
    public static boolean isValidNumber(String contact)
    {
        if(contact.length()<10){
            return false;
        }
        return true;
    }


    /**
     * Method to validate if couseCode is valid or not
     * @param courseCode
     * @param availableCourseList
     * @return couseCode is valid or not
     */
    public static boolean isValidCourseCode(String courseCode, List<Course> availableCourseList)
    {
        for(Course course : availableCourseList)
        {
            if(courseCode.equalsIgnoreCase(course.getCourseID()))
            {
                return true;
            }
        }

        return false;

    }
}
