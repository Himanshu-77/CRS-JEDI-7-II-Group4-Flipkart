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

    StudentOperation so = StudentOperation.getInstance();



    @PUT
	@Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    public Response loginUser( @NotNull
			@QueryParam("username") String username,
			@NotNull
			@QueryParam("password") String password,
			@NotNull
			@QueryParam("role") String role) {
        

        try {
        	UserOperation uo = UserOperation.getInstance();

            
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
            	return Response.status(200).entity("Login successful at "+ dtf.format(now)).build();
    			
            		
            }
            else {
            	return Response.status(500).entity("Invalid credentials!").build();
            }

        } catch (Exception e) {
        	e.printStackTrace();
        	return Response.status(500).entity(e.getMessage()).build();
        	
        }
		
    }

    
    @POST
	@Path("/register")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
    public Response registerStudent(Student student) {

          
    	 Student stud = new Student();
        try {
        	
             stud = so.addStudent(student.getUserID(), student.getName(), student.getPassword(), student.getDepartment(), student.getContactNumber(), student.getJoiningYear());

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
        	return Response.status(500).entity(e.getMessage()).build();
        }
        
        String result = "Added student : " + student.getName() +  " | Student ID : "+ stud.getStudentID() + ". Wait for admin approval!";
        return Response.status(201).entity(result).build();
    }

    @POST
	@Path("/updatePassword")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updatePassword(@QueryParam("username") String username,
			@NotNull
			@QueryParam("oldPassword") String oldPassword,
			@NotNull
			@QueryParam("role") String role,
			@NotNull
			@QueryParam("newPassword") String newPassword) {
        
    	
        try {
            

            UserOperation uo = new UserOperation();
            if(uo.loginUser(username, oldPassword, role))
            {
                
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
        	return Response.status(500).entity(e.getMessage()).build();
        	
        }
        return Response.status(201).entity("Password Update Successful!!!").build();
    }
}
