//<<<<<<< HEAD
///**
// *
// */
//package com.flipkart.exception;
//
///**
// * Exception to check student registered or not
// * @author Jayanth
// *
// */
//public class StudentNotRegisteredException extends Exception{
//
//	private String studentName;
//	private Integer studentID;
//
//	public String getStudentName() {
//		return studentName;
//	}
//	public void setStudentName(String studentName) {
//		studentName = studentName;
//	}
//	public Integer getStudentID() {
//		return studentID;
//	}
//	public void setStudentID(Integer studentID) {
//		this.studentID = studentID;
//	}
//
//	public String getMessage() {
//		return studentName +"( "+studentID+")"+"not registered, Register and try again";
//	}
//
//=======
package com.flipkart.exception;

//Exception arises when appropriate student details cant be found or are not present
public class StudentNotRegisteredException extends Exception {

	@Override
	public String getMessage() {
		return "No such registered student was found";
	}
}
