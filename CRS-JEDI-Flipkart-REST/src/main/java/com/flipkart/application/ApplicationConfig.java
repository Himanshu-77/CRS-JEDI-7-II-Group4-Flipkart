package com.flipkart.application;

import org.glassfish.jersey.server.ResourceConfig;

import com.flipkart.restcontroller.Controller;

public class ApplicationConfig extends ResourceConfig {

	
		public ApplicationConfig() {

			register(Controller.class);
//			register(AdminRESTApi.class);
//			register(ProfessorRESTApi.class);
//			register(StudentRESTApi.class);

		}

	}

