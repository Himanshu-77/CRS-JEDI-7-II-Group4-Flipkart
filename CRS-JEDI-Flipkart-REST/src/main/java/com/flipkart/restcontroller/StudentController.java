/**
 * 
 */
package com.flipkart.restcontroller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.flipkart.bean.Course;
import com.flipkart.bean.Payment;
import com.flipkart.bean.ReportCard;
import com.flipkart.business.PaymentOperation;
import com.flipkart.business.SemesterRegistrationInterface;
import com.flipkart.business.SemesterRegistrationOperation;
import com.flipkart.business.StudentInterface;
import com.flipkart.business.StudentOperation;
import com.flipkart.constants.constants;
import com.flipkart.exception.CourseExistsInCartException;
import com.flipkart.exception.FeesPendingException;
import com.flipkart.exception.GradeNotAddedException;
import com.flipkart.exception.StudentNotApprovedException;
import com.flipkart.exception.StudentNotRegisteredException;

/**
 * @author Dell
 *
 */

@Path("/student")
public class StudentController {
	
	static Scanner sc = new Scanner(System.in);

    SemesterRegistrationInterface sro = SemesterRegistrationOperation.getInstance();
    StudentInterface so = StudentOperation.getInstance();

    @GET
	@Path("/finishRegistration")
	@Produces(MediaType.APPLICATION_JSON)
    public Response finishRegistration(@NotNull
			@QueryParam("username") String username, 
			@NotNull
			@Min(value = 1, message = "Semester ID should not be less than 1")
			@Max(value = 8, message = "Semester ID should be less than 9")
			@QueryParam("semesterID")int semesterID) {

    	try {
    		boolean finishedRegistration = false;

            System.out.println("=======================================");
            System.out.println("Finishing registration...");
            int studentID = getStudentID(username);

            finishedRegistration = sro.finishRegistration(studentID, semesterID);

            if(finishedRegistration) {
            	return Response.status(200).entity("Registration completed successfully!").build();
            }
            else {
            	return Response.status(500).entity("Finish Registration action not done!!").build();
               
            }
    		
    	}
    	catch(Exception e) {
    		return Response.status(500).entity(e.getMessage()).build();
    	}
    	catch(Throwable e) {
    		return Response.status(500).entity(e.getMessage()).build();
    	}
        
    }

    @POST
   	@Path("/payFee")
   	@Produces(MediaType.APPLICATION_JSON)
    public Response payRegistrationFee(@NotNull
			@QueryParam("username") String username,
			@NotNull
			@QueryParam("type") String type,@NotNull
			@Min(value = 1, message = "Semester ID should not be less than 1")
			@Max(value = 8, message = "Semester ID should be less than 9")
			@QueryParam("semesterID")int semesterID) {

    	try {
    		
    		
    		int studentID = getStudentID(username);
        	boolean finishedRegistration = false;
            finishedRegistration = sro.finishRegistration(studentID, semesterID);

        	if (so.checkPaymentWindow(studentID))
            {
                Payment payment = new Payment();
                PaymentOperation po = new PaymentOperation();

                payment.setStudentID(studentID);
                payment.setPaymentMode(type);

                    if(!finishedRegistration) {
                    	return Response.status(500).entity("You registration is incomplete!").build();
                    }

                    if(!type.equals("Card") && !type.equals("NetBanking") && !type.equals("Cash") &&
                    		!type.equals("Cheque") && !type.equals("Scholarship")  ) {
                    	return Response.status(500).entity("Invalid Mode of payment!!").build();
                    }
                    
                    po.makePayment(payment);
                    
                    return Response.status(201).entity("Payment done successfully!").build();
                    
            }
            else {
            	 return Response.status(500).entity("Payment window not opened!").build();
            	
            }
    	}
    	catch (Exception e) {
    		return Response.status(500).entity(e.getMessage()).build();
            }
    	catch(Throwable e) {
    		return Response.status(500).entity(e.getMessage()).build();
    	}
		
        }


    @DELETE
	@Path("/dropCourse")
  	@Produces(MediaType.APPLICATION_JSON)
    public Response dropCourse(@NotNull
			  @QueryParam("courseID") String courseID,
			  @NotNull
			  @QueryParam("username")String username,
			  @NotNull
			  @QueryParam("semesterId") int semesterId) {



        boolean courseDropped = false;
		try {
			
			int studentID = getStudentID(username);
			courseDropped = sro.dropCourse(studentID, semesterId, courseID);
			if(courseDropped) {
	            System.out.println("Course dropped successfully!");
	        }
	        else {
	            return Response.status(500).entity("Course was not dropped from the cart.").build();
	        }

		} catch (Throwable e) {
			return Response.status(500).entity(e.getMessage()).build();
		}
		return Response.status(200).entity("Course dropped successfully!").build();

        
    }

 // Add course for a given student in a specific semester
    @POST
	@Path("/addCourse")
	@Produces(MediaType.APPLICATION_JSON)
    public Response addCourse(@NotNull
			@QueryParam("courseID") String courseID,
			@NotNull
			@QueryParam("semesterId") int semesterId,
			@NotNull
			@QueryParam("isPrimaryInt") int isPrimaryInt,
			@NotNull
			@QueryParam("username")String username) {

    	
        boolean isPrimary = isPrimaryInt == 1;
        int studentID;
		try {
			studentID = getStudentID(username);
			boolean courseAdded = false;
			courseAdded = sro.addCourse(studentID, semesterId, courseID, isPrimary);
			 if(courseAdded) {
		            System.out.println("Course added successfully!");
		            
		        }
		        else {
		            
		            return Response.status(500).entity("Course was not added to the cart.").build();
		        }
		} 
		
		catch (Exception e) {
			return Response.status(500).entity(e.getMessage()).build();
		}
		catch (CourseExistsInCartException e) {
			return Response.status(500).entity(e.getMessage()).build();
		}

		return Response.status(201).entity("Course added successfully!").build();
       
    }


    @GET
	@Path("/viewRegisteredCourses")
	@Produces(MediaType.APPLICATION_JSON)
    public Response viewRegisteredCourses(@NotNull
			@QueryParam("username") String username, 
			@NotNull
			@QueryParam("semesterID")int semesterID)  {

    	try {
    	
    		int studentID = getStudentID(username);
    		return Response.ok(so.viewRegisteredCourses(studentID, semesterID),MediaType.APPLICATION_JSON).build();

    	}
    	catch(Exception e) {
    		return Response.status(500).entity(e.getMessage()).build();
    	}
    	
    }

    @GET
	@Path("/viewGradeCard")
	@Produces(MediaType.APPLICATION_JSON)
    public Response viewGradeCard(@NotNull
			@QueryParam("username") String username, 
			@NotNull
			@QueryParam("semesterID")int semesterID) {
    	try {
    	
    		int studentID = getStudentID(username);
        	ReportCard R = so.viewReportCard(studentID, semesterID);
        	return Response.ok(R,MediaType.APPLICATION_JSON).build();
    	}
    	catch(Exception e) {
    		return Response.status(500).entity(e.getMessage()).build();
    	}
    }
    
    private int getStudentID(String username)throws Exception{

        int res;
		try {
			res = so.getStudentIDFromUserName(username);
			return res;
		} catch (Exception e) {
			throw e;
		}

        
	}

}
