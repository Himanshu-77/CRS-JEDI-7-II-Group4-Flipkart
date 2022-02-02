package com.flipkart.application;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.flipkart.bean.Student;
import com.flipkart.business.StudentOperation;
import com.flipkart.business.UserOperation;

public class CRSApplication {

    private Scanner sc = new Scanner(System.in);
    StudentOperation so = StudentOperation.getInstance();

    public static void main(String[] args) {
    	    	
        CRSApplication newUser = new CRSApplication();
        newUser.createMenu();
    }

    private void createMenu() {
        try {
            while(true) {
            	System.out.println("\n\n==~~=~~= Course Registration System ~=~~=~~=~~==");
                System.out.println("   Welcome !    ");
                System.out.println("\nChoose an option: ");
                System.out.println("---------------------------------------");
                System.out.println("1 : Student Self Registration");
                System.out.println("2 : Login");
                System.out.println("3 : Update Password");
                System.out.println("4 : Exit menu");
                System.out.println("=======================================");

                int menuOption = sc.nextInt();
                sc.nextLine();

                switch(menuOption) {
                    case 1:
                        registerStudent();
                        break;

                    case 2:
                        loginUser();
                        break;

                    case 3:
                        updatePassword();
                        break;

                    case 4:
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid input");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loginUser() {
        String username, password, role;

        try {
        	System.out.println("=======================================");
            System.out.print("Username: ");
            username = sc.nextLine();
            System.out.print("Password: ");
            password = sc.nextLine();
            System.out.print("Enter Role (student/professor/admin): ");
            role = sc.nextLine();
            
            UserOperation uo = new UserOperation();
            
            if(uo.loginUser(username, password, role))
            {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();

                switch (role) {
                    case "student":
                        System.out.println("=======================================");
                        System.out.println("Logged In Successfully as a Student");
                        System.out.println("Welcome "+username+ " !!");
                        System.out.println("Login Time: "+ dtf.format(now) );
                        CRSStudent sc = new CRSStudent();
                        sc.createStudentMenu(username);
                        break;

                    case "professor":
                        System.out.println("=======================================");
                        System.out.println("Logged In Successfully as a Professor");
                        System.out.println("Welcome "+username+ " !!");
                        System.out.println("Login Time: "+ dtf.format(now) );
                        CRSProfessor pc = new CRSProfessor();
                        pc.createProfessorMenu(username);
                        break;

                    case "admin":
                        System.out.println("=======================================");
                        System.out.println("Logged In Successfully as a Admin");
                        System.out.println("Welcome "+username+ " !!");
                        System.out.println("Login Time: "+ dtf.format(now) );
                        CRSAdmin ac = new CRSAdmin();
                        ac.createAdminMenu(username);
                        break;

                    default:
                        System.out.println("Invalid Role");
                        System.out.println("=======================================");
                }
            		
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void registerStudent() {

        String username, password, name, department, contact, joiningYear;

        try {
        	System.out.println("=======================================");
            System.out.println("Enter your details");
            System.out.println("---------------------------------------");
            System.out.print("Username: ");
            username = sc.nextLine();
            System.out.print("Password: ");
            password = sc.nextLine();
            System.out.print("Name: ");
            name = sc.nextLine();
            System.out.print("Department: ");
            department = sc.nextLine();
            System.out.print("Year of joining: ");
            joiningYear = sc.nextLine();
            System.out.print("Contact Number: ");
            contact = sc.nextLine();
            System.out.println("=======================================");
            
            Student stud = so.addStudent(username, name, password, department, contact, Integer.parseInt(joiningYear));

            if(stud == null) {
                System.out.println("User Was not added");
                System.out.println("=======================================");
            }
            else {
                System.out.println("User Added Successfully! Wait for admin approval!");
                System.out.println("=======================================");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void updatePassword() {
        String oldPassword,newPassword,username,role;
        try {
            System.out.println("=======================================");
            System.out.print("Enter Username: ");
            username = sc.nextLine();
            System.out.print("Enter existing Password: ");
            oldPassword = sc.nextLine();
            System.out.print("Enter Role (student/professor/admin): ");
            role = sc.nextLine();

            UserOperation uo = new UserOperation();
            if(uo.loginUser(username, oldPassword, role))
            {
                System.out.println("=======================================");
                System.out.print("Enter new Password: ");
                newPassword = sc.nextLine();
                switch (role) {
                    case "student":
                        uo.updateStudentPassword(username,newPassword);
                        break;

                    case "professor":
                        uo.updateProfPassword(username,newPassword);
                        break;

                    case "admin":
                        uo.updateAdminPassword(username,newPassword);
                        break;

                    default:
                        System.out.println("Invalid Role");
                        System.out.println("=======================================");
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
