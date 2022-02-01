package com.flipkart.application;

import com.flipkart.bean.Course;
import com.flipkart.bean.Payment;
import com.flipkart.bean.ReportCard;
import com.flipkart.exception.*;
import com.flipkart.business.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class CRSStudent {
    static Scanner sc = new Scanner(System.in);
    private int studentID;
    private boolean finishedRegistration = false;

    SemesterRegistrationInterface sro = SemesterRegistrationOperation.getInstance();
    StudentInterface so = StudentOperation.getInstance();


    public static void main(String[] args) {
//        StudentClient test = new StudentClient();
//        System.out.println("Enter You Username");
//        String username = sc.nextLine();
//        test.createStudentMenu(username);

        boolean a = sc.nextBoolean();
        System.out.println(a);
    }

    public void createStudentMenu(String username) {

        try {
        	
        	studentID = getStudentID(username);
            assert studentID != -1;

            while(true) {
            	System.out.println("\n\n==~~=~~=~~=~~=~Student Panel~=~~=~~=~~=~~==");
                System.out.println("Choose an option: ");
                System.out.println("---------------------------------------");
                System.out.println("1 : View report card");
                System.out.println("2 : View registered courses");
                System.out.println("3 : Open semester registration dashboard");
                System.out.println("4 : Logout");
                System.out.println("=======================================");

                int menuOption = sc.nextInt();
                sc.nextLine();

                switch(menuOption) {
                    case 1 :
                        viewGradeCard(studentID,1);
                        break;
                    case 2 :
                        viewRegisteredCourses(studentID,1);
                        break;
                    case 3:
                        createRegistrationDashboard();
                        break;
                    case 4:
                    	System.out.println("Logging Out ...");
                    	return;
                    default:
                        System.out.println("Invalid input");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
	private void createRegistrationDashboard() {
        Scanner sc = new Scanner(System.in);

        try {

            while(true) {
            	System.out.println("=======================================");
                System.out.println("Semester registration : ");
                System.out.println("---------------------------------------");
                System.out.println("1 : View available course details");
                System.out.println("2 : Add course");
                System.out.println("3 : Drop course");
                System.out.println("4 : Finish registration");
                System.out.println("5 : Make a payment and exit");
                System.out.println("6 : Exit");
                System.out.println("=======================================");

                int menuOption = sc.nextInt();

                switch(menuOption) {
                    case 1 :
                        viewAvailableCourses();
                        break;
                    case 2 :
                        addCourse();
                        break;
                    case 3:
                        dropCourse();
                        break;
                    case 4:
                        finishRegistration();
                        break;
                    case 5:
                        payRegistrationFee();
                        break;
                    case 6:
                        return;
                    default:
                        System.out.println("Invalid input");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void finishRegistration() {

        System.out.println("=======================================");
        System.out.println("Finishing registration...");

        finishedRegistration = sro.finishRegistration(studentID, 1);

        if(finishedRegistration) {
            System.out.println("Registration completed successfully!");
        }
        else {
            System.out.println("Finish Registration action not done!!");
        }
    }

    private void payRegistrationFee() {

        if (so.checkPaymentWindow(studentID)){
            Scanner sc = new Scanner(System.in);
            Payment payment = new Payment();
            PaymentOperation po = new PaymentOperation();

            payment.setStudentID(studentID);

            try {

                if(!finishedRegistration) {
                    throw new Exception("You registration is incomplete!");
                }

                System.out.println("=======================================");
                System.out.println("Choose a Payment type : ");
                System.out.println("---------------------------------------");
                System.out.println("1 : Card");
                System.out.println("2 : NetBanking");
                System.out.println("3 : Cash");
                System.out.println("4 : Cheque");
                System.out.println("=======================================");

                int menuOption = sc.nextInt();
                sc.nextLine();

                switch (menuOption) {
                    case 1:
                        System.out.println("=======================================");
                        System.out.println("Enter your card details");
                        System.out.println("---------------------------------------");
                        System.out.println("Enter card number : ");
//                        sc.nextLine();
                        String cardNumber = sc.nextLine();
                        payment.setPaymentMode("Card");
                        break;
                    case 2:
                        System.out.println("=======================================");
                        System.out.println("Enter your bank details");
                        System.out.println("---------------------------------------");
                        System.out.println("Enter account number : ");
//                        sc.nextLine();
                        String accountNumber = sc.nextLine();
                        payment.setPaymentMode("NetBanking");
                        break;
                    case 3:
                        payment.setPaymentMode("Cash");
                        break;
                    case 4:
                        payment.setPaymentMode("Cheque");
                        break;
                    default:
                        System.out.println("---------------------------------------");
                        System.out.println("Invalid input");
                        return;
                }

                po.makePayment(payment);

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }

    private void dropCourse() {

        System.out.println("=======================================");
        System.out.println("Delete Course");
        System.out.println("Enter course ID: ");

        String courseID = sc.nextLine();

        boolean courseDropped = false;
		try {
			courseDropped = sro.dropCourse(studentID, 1, courseID);

		} catch (Exception e) {
			e.printStackTrace();
		}

        if(courseDropped) {
            System.out.println("Course dropped successfully!");
        }
        else {
            System.out.println("Course was not dropped from the cart.");
        }
    }

    private void addCourse() {

    	System.out.println("=======================================");
        System.out.println("Add Course");
        System.out.println("Enter course ID: ");
        String courseID = sc.nextLine();
        System.out.println("Is primary(0/1) ? : ");
        int isPrimaryInt = sc.nextInt();
        sc.nextLine();
        boolean isPrimary = isPrimaryInt == 1;

        boolean courseAdded = false;
		try {
			courseAdded = sro.addCourse(studentID, 1, courseID, isPrimary);
		} catch (Exception e) {

			e.printStackTrace();
		}

        if(courseAdded) {
            System.out.println("Course added successfully!");
        }
        else {
            System.out.println("Course was not added to the cart.");
        }
    }

    private void viewAvailableCourses() {

        ArrayList<Course> courseCatalog = null;
        courseCatalog = sro.viewAvailableCourses();

        System.out.println("Course catalog : ");
        for(Course c : courseCatalog) {
            System.out.println("Course ID : "+c.getCourseID() +"\t Available seats : "+c.getAvailableSeats()+" \t Instructor : "+c.getInstructorID()+" \t Course Name : "+ c.getCoursename());
        }
    }

    private void viewRegisteredCourses(int studentID, int semesterID) throws StudentNotRegisteredException, SQLException {

    	so.viewRegisteredCourses(studentID, semesterID);
    }

    private void viewGradeCard(int studentID, int semesterID) throws SQLException, GradeNotAddedException, StudentNotApprovedException, FeesPendingException, StudentNotApprovedException {

    	ReportCard R = so.viewReportCard(studentID, semesterID);
    }
    
    private int getStudentID(String username){

        int res = so.getStudentIDFromUserName(username);
        assert res != -1;

        return res;
	}
}
