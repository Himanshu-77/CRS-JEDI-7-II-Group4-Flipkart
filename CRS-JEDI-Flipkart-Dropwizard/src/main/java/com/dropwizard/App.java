package com.dropwizard;

import com.flipkart.restcontroller.*;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * @author Dell
 *
 */
public class App extends Application<Configuration> {
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);
 
    /*
     * It is a dropwizard intitialize method which will intialize the configuration.
     * */
    @Override
    public void initialize(Bootstrap<Configuration> b) {
    }
 
    /*
     * Run will execute by the dropwizard container and registered all the web services here.
     * */

    @Override
    public void run(Configuration c, Environment e) throws Exception {
        LOGGER.info("Registering REST resources");

//        Register Controllers with jersey
        e.jersey().register(new AdminController());
        e.jersey().register(new ProfessorController());
        e.jersey().register(new UserController());
        e.jersey().register(new StudentController());
    }
 
    public static void main(String[] args) throws Exception {
        new App().run(args);
    }
}