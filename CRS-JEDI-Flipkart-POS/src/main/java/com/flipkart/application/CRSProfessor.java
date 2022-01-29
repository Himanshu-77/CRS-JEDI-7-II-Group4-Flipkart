package com.flipkart.application;

import java.sql.SQLException;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.GradeNotAddedException;
import com.flipkart.exception.ProfessorNotRegisteredException;
import com.flipkart.business.ProfessorInterface;
import com.flipkart.business.ProfessorOperation;

public class CRSProfessor {
	
	private static Logger logger = LogManager.getLogger(CRSProfessor.class);
	
	private Scanner sc = new Scanner(System.in);
    ProfessorInterface profObj = ProfessorOperation.getInstance();
    private int professorID;
    
    public static void main(String[] args) {
        CRSProfessor test = new CRSProfessor();
//        test.createProfessorMenu("Arka");
    }

    public void createProfessorMenu(String username) {
        try {

            professorID = getProfessorID(username);
            assert professorID != -1;

            while(true) {
                
            	System.out.println("\n\n==~~=~~=~~=~~=~Professor Panel~=~~=~~=~~=~~==");
                System.out.println("Choose an option : ");
                System.out.println("1 : View registered students");
                System.out.println("2 : Add Grade");
                System.out.println("3 : Show Registered courses");
                System.out.println("4 : Register for a course");
                System.out.println("5 : Logout");
                System.out.println("=======================================");

                int menuOption = sc.nextInt();
                sc.nextLine();

                switch(menuOption) {
                    case 1 :
                        viewEnrolledStudents();
                        break;
                    case 2 :
                        addGrade();
                        break;
                    case 3:
                        viewAvailableCourses();
                        break;
                    case 4:
                        registerCourse();
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("Invalid input");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void registerCourse() throws SQLException {

        String courseID;
        Integer semesterID;
        System.out.println("Enter course ID: ");
        courseID = sc.nextLine();
        System.out.println("Enter Semester ID: ");
        semesterID = sc.nextInt();
        sc.nextLine();
    	profObj.registerCourse(professorID, semesterID, courseID);
    }

    private void viewAvailableCourses() {

    	profObj.viewCourseProf(professorID);
    }

    private void addGrade() throws CourseNotFoundException, GradeNotAddedException {

    	String courseID;
    	Integer grade,semesterID,studentID;
        System.out.println("Enter student ID: ");
        studentID = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Semester ID: ");
        semesterID = sc.nextInt();
        System.out.println("Enter course ID: ");
        sc.nextLine();
        courseID = sc.nextLine();
        System.out.println("Enter Grade: ");
        grade = sc.nextInt();
        sc.nextLine();
    	profObj.addGrade(studentID, semesterID, courseID, grade);
        // get students details/objects


    }

   

    private void viewEnrolledStudents() throws CourseNotFoundException {

    	String courseID;
    	int semesterID;

        System.out.println("Enter course ID: ");
        courseID= sc.nextLine();
        System.out.println("Enter semester ID: ");
        semesterID = sc.nextInt();

    	try {
        	profObj.viewCourseStudents(courseID, semesterID);
    	}
    	catch(Exception e) {
    		throw new CourseNotFoundException(courseID);
    	}
    	
    }

    private Integer getProfessorID(String username) throws SQLException {

//
        return -1;
    }
}
