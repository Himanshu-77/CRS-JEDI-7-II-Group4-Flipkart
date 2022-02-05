/**
 * 
 */
package com.flipkart.restcontroller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.ReportCard;
import com.flipkart.bean.Student;
import com.flipkart.business.AdminInterface;
import com.flipkart.business.AdminOperation;
import com.flipkart.business.SemesterRegistrationInterface;
import com.flipkart.business.SemesterRegistrationOperation;
import com.flipkart.constants.constants;
import com.flipkart.exception.InvalidSemesterException;

/**
 * @author Dell
 *
 */
@Path("/admin")
public class AdminController {
	
	private static final Logger logger = Logger.getLogger(AdminController.class);


	AdminOperation ao = AdminOperation.getInstance();
	SemesterRegistrationOperation sro = SemesterRegistrationOperation.getInstance();

  @GET
  @Path("/getCourses")
  @Produces(MediaType.APPLICATION_JSON)
  
//GET API to view course details
  public Response viewAvailableCourses() {

	  try {
      
		  return Response.ok(sro.viewAvailableCourses(),MediaType.APPLICATION_JSON).build();
	  }
	  catch(Exception e) {
		  return Response.status(500).entity(e.getMessage()).build();
	  }

  }
  
 //GET API to view pending student login accounts
  	@GET
	@Path("/getPendingStudentAccount")
	@Produces(MediaType.APPLICATION_JSON)
	public Response approvePendingStudentAccounts() {
		
  		try {
  					
  			return Response.ok(ao.getPendingStudentAccountsList(),MediaType.APPLICATION_JSON).build();
  			
  		}
  		catch(Exception e) {
  			return Response.status(500).entity(e.getMessage()).build();
  		}
		
	}

 // POSt API to approve pending student login accounts
  	@POST
	@Path("/approvePendingStudentAccount")
	@Produces(MediaType.APPLICATION_JSON)
  	public Response approvePendingStudentAccounts(@NotNull
			@QueryParam("studentID") Integer studentID) {
		
  	try { 
  		ao.getPendingStudentAccountsList();
      	ao.approveStudentAccount(studentID);

  	}
  	
  	catch(Exception e) {
  		return Response.status(500).entity(e.getMessage()).build();
  	
  	}
  	
  	return Response.status(201).entity( "Student ID "+studentID + " Successfully Approved").build();
  	
	}

 // GET API to view course wise student list for all courses
  	@GET
	@Path("/viewAllCourseStudentList")
	@Produces(MediaType.APPLICATION_JSON)
  	public Response viewAllCourseStudentList() {
  		String courseID="";
  		Boolean viewAll = true;
  		
  		try {
		
		return Response.ok(ao.viewCourseStudentList (courseID,constants.SemesterID,viewAll),MediaType.APPLICATION_JSON).build();
	
  		}
	catch(Exception e) {
		
		return Response.status(500).entity(e.getMessage()).build();
	  	
	}
	    
}

  	 // GET API to view course wise student list for given courseID
	@GET
	@Path("/viewCourseStudentList")
	@Produces(MediaType.APPLICATION_JSON)
	public Response viewCourseStudentList(@NotNull
			@QueryParam("courseID") String courseID) {
		
		Boolean viewAll = false;
  		
  		try {
		
		return Response.ok(ao.viewCourseStudentList (courseID,constants.SemesterID,viewAll),MediaType.APPLICATION_JSON).build();
	
  		}
	catch(Exception e) {
		
		return Response.status(500).entity(e.getMessage()).build();
	  	
	}
  	

      
  }
	 // POST API to enable fee payment for student for a given semester
  	@POST
	@Path("/enableFeePaymentWindow")
	@Produces(MediaType.APPLICATION_JSON)
  	public Response enableFeePaymentWindow(@NotNull
  			@Min(value = 1, message = "Semester ID should not be less than 1")
			@Max(value = 8, message = "Semester ID should be less than 9")
  			@QueryParam("semesterID") Integer semesterID){
      
  		try {
  			ao.enableFeePayment(semesterID);
  			
  		}
  		catch(Exception e) {
  			return Response.status(500).entity(e.getMessage()).build();
  			
  		}
  		return Response.status(201).entity("******* Payment Window Opened Successfully for Semester "+ semesterID +" ******** ").build();
  		

     

  }

  	 // DELETE API to remove professor
  	@DELETE
	@Path("/removeProfessor")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON) 	
  	public Response removeProfessor(@NotNull
		  @QueryParam("professorID") Integer professorID) {
      
  	try {
          ao.removeProfessor(professorID);                            

      } catch (Exception e) {
    	  return Response.status(500).entity(e.getMessage()).build();
      }
  	return Response.status(200).entity("Professor Removed sucessfully!!!").build();
		
  }


  	 // POST API to add professor
  	@POST
	@Path("/addProfessor")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
  	public Response addProfessorDetails(Professor Prof) {
  	
  	
      try {    
          ao.addProfessor(Prof);

      } catch (Exception e) {
    	  return Response.status(500).entity(e.getMessage()).build();
      }
      
      return Response.status(201).entity("Professor Added sucessfully!!! ").build();
		
  }

  	 // POST API to approve student registration
  	@POST
	@Path("/approveStudentRegistration")
	@Produces(MediaType.APPLICATION_JSON)
  	public Response approveStudentRegistration(@NotNull
  		  @QueryParam("studentID") int studentID) {

      try {
			ao.approveStudentRegistration(studentID,constants.SemesterID);
		} catch (Exception e) {
			return Response.status(500).entity(e.getMessage()).build();
		}
      return Response.status(201).entity("Student Approved sucessfully!!! ").build();
  }

 // POST API to generate report card
  	@POST
	@Path("/generateReportCard")
	@Produces(MediaType.APPLICATION_JSON)
  	public Response generateReportCard(@NotNull
    		  @QueryParam("studentID") int studentID) {
      
      ReportCard R = new ReportCard();
		try {
			R = ao.generateReportCard(studentID);
		} catch (Exception e) {
			return Response.status(500).entity(e.getMessage()).build();
		}

		if(R.getSpi() > 0)
      System.out.println();
		else {
			return Response.status(500).entity("Report Card not generated!!").build();
		}
		return Response.status(200).entity("Student ID : "+studentID + "    SPI : "+ R.getSpi() ).build();
  }

 // DELETE API to remove course from course catalog
  	@DELETE
	@Path("/removeCourse")
  	@Produces(MediaType.APPLICATION_JSON) 
  	public Response removeCourse(@NotNull
  			  @QueryParam("courseID") String courseID) {
      
      try {
			ao.removeCourse(courseID);
		} 
      catch (Exception e) {
			return Response.status(500).entity(e.getMessage()).build();
		}
      return Response.status(200).entity("Course Removed sucessfully!!! ").build();
  }

  	// POST API to add course to course catalog
  	@POST
	@Path("/addCourse")
	@Produces(MediaType.APPLICATION_JSON)
  	public Response addCourse(@NotNull
  		  @QueryParam("course_name") String course_name,
  		  @NotNull
		  @QueryParam("courseID") String courseID,
		  @NotNull
		  @QueryParam("offeredSemester") int offeredSemester) {

      try{
          
        ao.addCourse(course_name, courseID, offeredSemester);

      } catch (Exception e) {
    	  return Response.status(500).entity(e.getMessage()).build();
      }
      return Response.status(201).entity("Course Added sucessfully!!! ").build();
  }

}
