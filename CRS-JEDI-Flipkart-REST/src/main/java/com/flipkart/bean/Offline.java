/**
 * 
 */
package com.flipkart.bean;

/**
 * @author Dell
 *
 */
public class Offline extends Payment{
	private String cashier;
	private String branch;
	private String transactionType;

	
	public Offline() {
		cashier = "null";
		branch = "null";
		transactionType = "null";
	}
	public Offline(String cashier, String branch, String transactionType) {
		super();
		this.cashier = cashier;
		this.branch = branch;
		this.transactionType = transactionType;
	}
	public String getCashier() {
		return cashier;
	}
	public void setCashier(String cashier) {
		this.cashier = cashier;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	

}
