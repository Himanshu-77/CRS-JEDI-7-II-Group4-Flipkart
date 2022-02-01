/**
 * 
 */
package com.flipkart.bean;

/**
 * @author Dell
 *
 */
public class Notification {
	private String notificationID;
	private String paymentID;
	private String message;

	
	public Notification() {
		notificationID="null";
		paymentID="null";
		message="NothingToDisplay";
	}
	
	
	public Notification(String notificationID, String paymentID, String message) {
		super();
		this.notificationID = notificationID;
		this.paymentID = paymentID;
		this.message = message;
	}
	public String getNotificationID() {
		return notificationID;
	}


	public void setNotificationID(String notificationID) {
		this.notificationID = notificationID;
	}


	public String getPaymentID() {
		return paymentID;
	}


	public void setPaymentID(String paymentID) {
		this.paymentID = paymentID;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}

	public void showPaymentNotification(String message,String ID){
		System.out.println("+-----------------------------------+");
		System.out.println("|         Notification Alert!       |");
		System.out.println("+-----------------------------------+");
		System.out.println("|          Payment Completed!       |");
		System.out.println("|   Student ID: " + message);
		System.out.println("|   Amount    : " + "1000");
		System.out.println("|   Transaction ID: " + ID);
		System.out.println("+-----------------------------------+");
	}

	public void showRegistrationNotification(){
		System.out.println("+-----------------------------------+");
		System.out.println("|         Notification Alert!       |");
		System.out.println("+-----------------------------------+");
		System.out.println("|      Registration Completed!      |");
		System.out.println("|    Please Complete Fee Payment!   |");
		System.out.println("+-----------------------------------+");
	}


}
