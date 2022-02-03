package com.flipkart.application;

import org.glassfish.jersey.server.ResourceConfig;

import com.flipkart.restcontroller.AdminController;
import com.flipkart.restcontroller.Controller;
import com.flipkart.restcontroller.ProfessorController;
import com.flipkart.restcontroller.UserController;

public class ApplicationConfig extends ResourceConfig {

	
		public ApplicationConfig() {

			register(Controller.class);
			register(UserController.class);
			register(ProfessorController.class);
			register(AdminController.class);
//			register(AdminRESTApi.class);
//			register(ProfessorRESTApi.class);
//			register(StudentRESTApi.class);

		}

	}

