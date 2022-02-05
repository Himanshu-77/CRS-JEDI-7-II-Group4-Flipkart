package com.flipkart.validator;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;

import java.util.List;

public class AdminValidator {


    /**
     * Method to check if semester is valid
     * @param semester: Semester ID
     * @return true, if semester is valid else, false.
     */
    public static boolean isValidSemester(int semester)
    {
       if(semester<1 || semester >8){
           return false;
       }
       return true;
    }

    /**
     * Method to check if Contact details are valid
     * @param contact: Contact details of professor
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
     * Method to validate if a course is new in catalog
     * @param newCourse
     * @param courseList
     * @return true, if Course is not present in catalog
     */
    public static boolean isValidNewCourse(Course newCourse, List<Course> courseList) {
        for(Course course : courseList) {
            if(newCourse.getCourseID().equalsIgnoreCase(course.getCourseID())) {
                return false;
            }
        }
        return true;
    }





}
