/**
 * 
 */
package com.flipkart.restcontroller;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author Dell
 *
 */
@Path("/customer")
public class Controller {
	
	@GET
	@Path("/api")
	@Produces(MediaType.TEXT_PLAIN)
	public String getData() {
		return "Hello World";
		
	}
	
	@GET
	@Path("/api2")
	@Produces(MediaType.APPLICATION_JSON)
	public String getDat1() {
		return "Hello World";
		
	}
	
	
	

}
