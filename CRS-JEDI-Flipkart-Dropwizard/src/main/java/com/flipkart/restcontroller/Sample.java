package com.flipkart.restcontroller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/sample")
public class Sample {




    @Path("/api1")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String func(){
        return "Hello World";
    }

}
