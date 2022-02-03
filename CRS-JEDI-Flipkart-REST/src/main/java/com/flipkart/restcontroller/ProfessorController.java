/**
 * 
 */
package com.flipkart.restcontroller;

import java.sql.SQLException;
import java.util.Scanner;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.flipkart.application.CRSProfessor;
import com.flipkart.business.ProfessorInterface;
import com.flipkart.business.ProfessorOperation;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.GradeNotAddedException;

/**
 * @author Dell
 *
 */
@Path("/professor")
public class ProfessorController {
	
private static Logger logger = Logger.getLogger(CRSProfessor.class);
	
    ProfessorInterface profObj = ProfessorOperation.getInstance();
    private int professorID;


    // register for a course
    @POST
	@Path("/registerCourse")
	@Produces(MediaType.APPLICATION_JSON)
    public Response registerCourse(@NotNull
			@QueryParam("username") String username,
			@NotNull
			@QueryParam("courseId") String courseId,
			@NotNull
			@QueryParam("semesterID") Integer semesterID) {

    	try {
    		
    		professorID = getProfessorID(username);
            
            profObj.registerCourse(professorID, semesterID, courseId);
    	}
    	catch(Exception e) {
    		return Response.status(500).entity(e.getMessage()).build();
    	}
    	return Response.status(200).entity( "Successfully Registered").build();
    	
    	
    }

    // View all available courses for a given professor
    @GET
	@Path("/getCourses")
	@Produces(MediaType.APPLICATION_JSON)
    public Response viewAvailableCourses(@NotNull
			@QueryParam("username") String username) {
    	
    	
    	try {
			professorID = getProfessorID(username);
			return Response.ok(profObj.viewCourseProf(professorID),MediaType.APPLICATION_JSON).build();
		} catch (Exception e) {
			logger.error(e.getMessage());
			return Response.status(500).entity(e.getMessage()).build();
			
		}
        
    	
    }

    
    // Add grade for a given student in a specific course and semester
    @POST
	@Path("/addGrade")
	@Produces(MediaType.APPLICATION_JSON)
    public Response addGrade(@NotNull
			@Min(value = 1, message = "Student ID should not be less than 1")
			@Max(value = 9999, message = "Student ID should be less than 10000")
			@QueryParam("studentId") Integer studentId,	
			@QueryParam("semesterID") Integer semesterID,	
			@NotNull
			@QueryParam("courseId") String courseId,
			@Min(value = 1, message = "Grade should not be less than 1")
			@Max(value = 10, message = "Grade should be less than 11")
			@QueryParam("grade") Integer grade)  {

    	try {
    		
    		profObj.addGrade(studentId, semesterID, courseId, grade);
        	
    	}
    	catch(Exception ex){
    		return Response.status(500).entity(ex.getMessage()).build();
    	}
    	
    	
    	return Response.status(200).entity( "Grade updated for student: "+studentId).build();
    }

    
    // View all registered students for a given course and semesterID
    @GET
	@Path("/getRegisteredStudents")
	@Produces(MediaType.APPLICATION_JSON)
    public Response viewEnrolledStudents(@NotNull
			@QueryParam("courseId") String courseId,
			@NotNull
			@QueryParam("semesterID") Integer semesterID){

    
    	try {
    		
    		return Response.ok(profObj.viewCourseStudents(courseId, semesterID),MediaType.APPLICATION_JSON).build();
    	}	
    	catch(Exception e) {
    		
    		return Response.status(500).entity(e.getMessage()).build();
    	}
    	
    	
    }

//    Get professor ID by entering username
    private Integer getProfessorID(String username) throws Exception {

        ProfessorInterface po = ProfessorOperation.getInstance();
        try {
            return po.getProfessorID(username);
        } catch (Exception e) {

            throw e;
        }
    }

}
