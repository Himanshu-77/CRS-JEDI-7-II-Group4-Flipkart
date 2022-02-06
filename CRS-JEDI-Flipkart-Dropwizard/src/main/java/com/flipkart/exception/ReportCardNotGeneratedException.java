package com.flipkart.exception;

// Exception arises when report card is accessed but not yet generated.
public class ReportCardNotGeneratedException extends Exception {
	@Override
	public String getMessage() {
		return "Report Card Not Generated !";
	}
}
