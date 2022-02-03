package com.flipkart.restcontroller;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.flipkart.application.CRSAdmin;
import com.flipkart.application.CRSProfessor;
import com.flipkart.application.CRSStudent;
import com.flipkart.bean.Student;
import com.flipkart.business.StudentOperation;
import com.flipkart.business.UserOperation;
import com.flipkart.dao.StudentDaoInterface;
import com.flipkart.dao.StudentDaoOperation;
import com.flipkart.exception.InvalidRoleException;
import com.flipkart.exception.LoginFailedException;
import com.flipkart.exception.UserNotFoundException;

@Path("/user")
public class UserController {

//    private Scanner sc = new Scanner(System.in);
//    StudentOperation so = StudentOperation.getInstance();
//	StudentDaoInterface SDO =StudentDaoOperation.getInstance();



	@GET
	@Path("/api3")
	@Produces(MediaType.APPLICATION_JSON)
	public String getDat1() {
		return "Hello World";
		
	}

    @PUT
	@Path("/login")
//    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response loginUser( @NotNull
			@QueryParam("username") String username,
			@NotNull
			@QueryParam("password") String password,
			@NotNull
			@QueryParam("role") String role) {
        

        try {
        	UserOperation uo = UserOperation.getInstance();

//        	String role = "admin";
//        	boolean loggedIn = uo.loginUser("admin", "admin", "admin");
            
        	boolean loggedIn = uo.loginUser(username, password, role);
            
        	
            if(loggedIn)
            {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();

                switch (role) {
                    case "student":
                        System.out.println("=======================================");
                        System.out.println("Logged In Successfully as a Student");
                        System.out.println("Welcome "+username+ " !!");
                        System.out.println("Login Time: "+ dtf.format(now) );
         
                        break;

                    case "professor":
                        System.out.println("=======================================");
                        System.out.println("Logged In Successfully as a Professor");
                        System.out.println("Welcome "+username+ " !!");
                        System.out.println("Login Time: "+ dtf.format(now) );
                      
                        break;

                    case "admin":
                        System.out.println("=======================================");
                        System.out.println("Logged In Successfully as a Admin");
                        System.out.println("Welcome "+username+ " !!");
                        System.out.println("Login Time: "+ dtf.format(now) );
                        
                        break;

                    default:
                        System.out.println("Invalid Role");
                        System.out.println("=======================================");
                }
            	return Response.status(200).entity("Login successful").build();
    			
            		
            }
            else {
            	return Response.status(500).entity("Invalid credentials!").build();
            }

        } catch (Exception e) {
        	e.printStackTrace();
        	return Response.status(500).entity(e.getMessage()).build();
        	
        }
		
    }
//
//    private void registerStudent() {
//
//        String username, password, name, department, contact, joiningYear;
//
//        try {
//        	System.out.println("=======================================");
//            System.out.println("Enter your details");
//            System.out.println("---------------------------------------");
//            System.out.print("Username: ");
//            username = sc.nextLine();
//            System.out.print("Password: ");
//            password = sc.nextLine();
//            System.out.print("Name: ");
//            name = sc.nextLine();
//            System.out.print("Department: ");
//            department = sc.nextLine();
//            System.out.print("Year of joining: ");
//            joiningYear = sc.nextLine();
//            System.out.print("Contact Number: ");
//            contact = sc.nextLine();
//            System.out.println("=======================================");
//            
//            Student stud = so.addStudent(username, name, password, department, contact, Integer.parseInt(joiningYear));
//
//            if(stud == null) {
//                System.out.println("User Was not added");
//                System.out.println("=======================================");
//            }
//            else {
//                System.out.println("User Added Successfully! Wait for admin approval!");
//                System.out.println("=======================================");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    
//    private void updatePassword() {
//        String oldPassword,newPassword,username,role;
//        try {
//            System.out.println("=======================================");
//            System.out.print("Enter Username: ");
//            username = sc.nextLine();
//            System.out.print("Enter existing Password: ");
//            oldPassword = sc.nextLine();
//            System.out.print("Enter Role (student/professor/admin): ");
//            role = sc.nextLine();
//
//            UserOperation uo = new UserOperation();
//            if(uo.loginUser(username, oldPassword, role))
//            {
//                System.out.println("=======================================");
//                System.out.print("Enter new Password: ");
//                newPassword = sc.nextLine();
//                switch (role) {
//                    case "student":
//                        uo.updateStudentPassword(username,newPassword);
//                        break;
//
//                    case "professor":
//                        uo.updateProfPassword(username,newPassword);
//                        break;
//
//                    case "admin":
//                        uo.updateAdminPassword(username,newPassword);
//                        break;
//
//                    default:
//                        System.out.println("Invalid Role");
//                        System.out.println("=======================================");
//                }
//
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
