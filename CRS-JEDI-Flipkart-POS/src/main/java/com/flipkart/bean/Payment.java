/**
 * 
 */
package com.flipkart.bean;

import javax.print.DocFlavor.INPUT_STREAM;

/**
 * @author Dell
 *
 */
public class Payment {
	
	private Integer paymentID;
	private Integer amount;
	private Integer studentID;
	private Boolean paymentStatus;
	private String paymentMode;

	
	public Payment() {
		paymentID=null;
		amount=0;
		studentID=0;
		paymentStatus=false;
		paymentMode=null;
	}
	
	public Payment(Integer paymentID, Integer amount, Integer studentID, Boolean paymentStatus, String paymentMode) {
		super();
		this.paymentID = paymentID;
		this.amount = amount;
		this.studentID = studentID;
		this.paymentStatus = paymentStatus;
		this.paymentMode = paymentMode;
	}
	public Integer getPaymentID() {
		return paymentID;
	}
	public void setPaymentID(Integer paymentID) {
		this.paymentID = paymentID;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Integer getStudentID() {
		return studentID;
	}
	public void setStudentID(Integer studentID) {
		this.studentID = studentID;
	}
	public Boolean getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(Boolean paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	
}
