package com.flipkart.exception;

public class ReportCardNotGeneratedException extends Exception {
	@Override
	public String getMessage() {
		return "Report Card Not Generated !";
	}
}
