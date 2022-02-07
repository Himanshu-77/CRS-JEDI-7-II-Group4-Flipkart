package com.flipkart.application;

import org.glassfish.jersey.server.ResourceConfig;

import com.flipkart.restcontroller.AdminController;
import com.flipkart.restcontroller.ProfessorController;
import com.flipkart.restcontroller.StudentController;
import com.flipkart.restcontroller.UserController;

public class ApplicationConfig extends ResourceConfig {

	
		public ApplicationConfig() {

//			Register User Controller class with Server
			register(UserController.class);
			
//			Register Professor Controller class with Server
			register(ProfessorController.class);
			
//			Register Admin Controller class with Server
			register(AdminController.class);
			
//			Register Student Controller class with Server
			register(StudentController.class);

		}

	}

