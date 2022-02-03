package com.flipkart.application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.logging.LogManager;

import org.apache.log4j.Logger;
import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.ReportCard;
import com.flipkart.bean.Student;
import com.flipkart.business.SemesterRegistrationInterface;
import com.flipkart.business.SemesterRegistrationOperation;
import com.flipkart.constants.constants;
import com.flipkart.business.AdminInterface;
import com.flipkart.business.AdminOperation;
import com.flipkart.exception.InvalidSemesterException;






public class CRSAdmin {

//    private static final Logger logger = LogManager.getLogger(CRSAdmin.class);
	private static final Logger logger = Logger.getLogger(CRSAdmin.class);
    
	
    private Scanner sc = new Scanner(System.in);
    AdminInterface ao = AdminOperation.getInstance();
    SemesterRegistrationInterface sro = SemesterRegistrationOperation.getInstance();

    public void createAdminMenu(String username) {
        try {

            while(true) {
            	System.out.println("\n\n==~~=~~=~~=~~=~Admin Panel~=~~=~~=~~=~~==");
                System.out.println("Choose an option : ");
                System.out.println("---------------------------------------");
                System.out.println("1 : Edit course details");
                System.out.println("2 : Generate report card");
                System.out.println("3 : Approve student semester registration");
                System.out.println("4 : Add Professor");
                System.out.println("5 : Remove Professor");
                System.out.println("6 : View Course Wise student list");
                System.out.println("7 : Approve Pending Student Accounts");
                System.out.println("8 : Enable Fee Payment Window");
                System.out.println("9 : View available course details");
                System.out.println("10 : Logout");
                System.out.println("=======================================");

                int menuOption = sc.nextInt();
                sc.nextLine();

                switch(menuOption) {
                    case 1 :
                        editCourseList();
                        break;
                    case 2 :
                        generateReportCard();
                        break;
                    case 3:
                        approveStudentRegistration();
                        break;
                    case 4:
                    	addProfessorDetails();
                        break;
                    case 5:
                    	removeProfessor();
                        break;
                    case 6:
                        viewCourseStudentList();
                        break;
                    case 7:
                    	approvePendingStudentAccounts();
                    	break;
                    case 8:
                        enableFeePaymentWindow();
                        break;
                    case 9:
                        viewAvailableCourses();
                        break;
                    case 10:
                        return;

                    default:
                        System.out.println("Invalid input");
                }
            }

        } catch (Exception e) {
            logger.error(e.getMessage());
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


    private void approvePendingStudentAccounts() {
		
    	List<Student> pendingStudents = ao.getPendingStudentAccountsList();
    	if(!pendingStudents.isEmpty()) {
    		System.out.println("List of Students with Pending Account Approval : ");
        	System.out.println();
        	System.out.println("Student ID\t Name\t Department\t Joining Year\t Contact Number");
        	for(Student st: pendingStudents) {
        		System.out.println(st.getStudentID()+"\t"+st.getName()+"\t"+st.getDepartment()+"\t"+st.getJoiningYear()+"\t"+st.getContactNumber());
        	}
        	System.out.println("\n Enter the Student ID for the Student Account you want to approve : ");
    		Integer studentID = sc.nextInt();
    		sc.nextLine();
    		
    		ao.approveStudentAccount(studentID);
    	}

    	
	}

	private void viewCourseStudentList() {
    	
    	System.out.println("\n\n==~~=~~=~Course Details~=~~=~~=~~==");
        System.out.println("Choose an option : ");
        System.out.println("---------------------------------------");
        System.out.println("1 : View All Course's Details");
        System.out.println("2 : View for a particular course");
        System.out.println("=======================================");
        int menuOption = sc.nextInt();
        sc.nextLine();

    	String courseID="";
    	Boolean viewAll = true;
        switch(menuOption) {
            case 1 :
                break;
            case 2 :
            	viewAll=false;
            	System.out.println("Enter course ID: ");
            	courseID = sc.nextLine();
                break;
            default:
                System.out.println("Invalid input");
        }

        HashMap<String,ArrayList<Integer> > CourseStudentList = ao.viewCourseStudentList (courseID,constants.SemesterID,viewAll);
        System.out.println("+-------------------------------------+");

        CourseStudentList.entrySet().forEach(entry -> {
    	    System.out.println("| Course ID : " + entry.getKey());
    	    System.out.print("| Students Enrolled : \n| " );
    	    for(Integer stID : entry.getValue()) {
    	    	System.out.print(stID.toString()+"\t");
    	    }

    	    System.out.println();
    	    System.out.println("+-------------------------------------+");
    	});
        
    }

    private void enableFeePaymentWindow(){
        System.out.println("=======================================");
        int a = 0 ;
        System.out.println("Enter Semester No. to enable Payment Window : ");
        System.out.println("Enter -1 to exit: ");
        a = sc.nextInt();
        if (a == -1) {
            System.out.println("*********** Exit Successful *************");
        }

        else if (a > 0 && a < 9){
            ao.enableFeePayment(a);
            }

        else {
            try {
                throw new InvalidSemesterException();
            }
            catch (InvalidSemesterException ex) {
                System.out.println(ex.getMessage());
            }

        }

    }

    private void removeProfessor() {
    	System.out.println("Enter Instructor ID :");
    	Integer professorID = sc.nextInt();
        
    	try {
            ao.removeProfessor(professorID);                            

        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }



    private void addProfessorDetails() {
    	
    	
        try {

            String username, name, password, department, designation, contact;
            Integer joiningYear;
            
            System.out.println("=======================================");
            System.out.println("Enter professor details");
            System.out.println("---------------------------------------");
            System.out.println("User Name: ");
            username = sc.nextLine();
            System.out.println("Password: ");
            password = sc.nextLine();
            System.out.println("Name: ");
            name = sc.nextLine();
            System.out.println("Department: ");
            department = sc.nextLine();
            System.out.println("Designation: ");
            designation = sc.nextLine();
            System.out.println("Contact Number");
            contact = sc.nextLine();
            System.out.println("Joining Year");
            joiningYear = sc.nextInt();
            System.out.println("=======================================");

            Professor Prof = new Professor();
            Prof.setUserID(username);
            Prof.setName(name);
            Prof.setPassword(password);
            Prof.setDepartment(department);
            Prof.setDesignation(designation);
            Prof.setContactNumber(contact);
            Prof.setJoiningYear(joiningYear);
            
            ao.addProfessor(Prof);

        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    private void approveStudentRegistration() {
        int studentID;
        System.out.println("Enter student ID: ");
        studentID = sc.nextInt();

        try {
			ao.approveStudentRegistration(studentID,constants.SemesterID);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
    }

    private void generateReportCard() {
        int studentID;
        System.out.println("Enter student ID: ");
        studentID = sc.nextInt();
        ReportCard R = new ReportCard();
		try {
			R = ao.generateReportCard(studentID);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		if(R.getSpi() > 0)
        System.out.println("Student ID : "+studentID+"    SPI : "+ R.getSpi());
		else {
			System.out.println("Report Card not generated!!");
		}
    }

    private void editCourseList() {
        
        try {

            while(true) {
            	System.out.println("=======================================");
                System.out.println("Options : ");
                System.out.println("---------------------------------------");
                System.out.println("1 : Add course");
                System.out.println("2 : Remove course");
                System.out.println("3 : Exit");
                System.out.println("=======================================");

                int menuOption = sc.nextInt();
                sc.nextLine();

                switch(menuOption) {
                    case 1 :
                        addCourse();
                        break;
                    case 2 :
                        removeCourse();
                        break;
                    case 3:
                        return;
                    default:
                        System.out.println("Invalid input");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void removeCourse() {
        String courseID;
        System.out.println("=======================================");
        System.out.println("Enter course ID: ");
        courseID = sc.nextLine();
        
        try {
			ao.removeCourse(courseID);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
    }

    private void addCourse() {

        try{
            String course_name, courseID;
            int offeredSemester;
            
            System.out.println("=======================================");
            System.out.println("Enter course details");
            System.out.print("Course Name: ");
            course_name = sc.nextLine();
            System.out.print("Course ID: ");
            courseID = sc.nextLine();
            System.out.print("Semester: ");
            offeredSemester = sc.nextInt();
            
            ao.addCourse(course_name, courseID, offeredSemester);

        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }
}
