package com.flipkart.validator;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;

import java.util.List;

public class ProfessorValidator {


    /**
     * Method to check if grade is valid
     * @param grade: Student Grades
     * @return true, if semester is valid else, false.
     */
    public static boolean isValidGrade(Integer grade)
    {
        if(grade<1 || grade >10){
            return false;
        }
        return true;
    }


    /**
     * Method to check if Student exist in the database
     * @param students: list of students in the database
     * @param studentId: current student
     * @return true, if student is valid. else, false.
     */
    public static boolean isValidStudent(List<Student> students, int studentId)
    {
        boolean result=false;
        //check if student exist in ihe students list
        for(int i=0;i<students.size();i++)
        {
            //role.equalsIgnoreCase("ADMIN")
            if(students.get(i).getStudentID()==studentId)
                result=true;

        }
        return result;
    }

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





}
