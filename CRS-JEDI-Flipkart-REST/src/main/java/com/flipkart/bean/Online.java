/**
 * 
 */
package com.flipkart.bean;

/**
 * @author Dell
 *
 */
public class Online extends Payment{
	private String transactionType;

	
	public Online() {
		transactionType="null";
	}
	
	public Online(String transactionType) {
		super();
		this.transactionType = transactionType;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

}
