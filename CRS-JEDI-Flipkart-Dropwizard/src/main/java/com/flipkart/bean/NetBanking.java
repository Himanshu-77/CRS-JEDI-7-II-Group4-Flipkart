/**
 * 
 */
package com.flipkart.bean;

/**
 * @author Dell
 *
 */
public class NetBanking extends Online {
	private String bank;
	private String accountNumber;

	public NetBanking() {
		this.bank="abc";
		this.accountNumber="1231231231232";
	}
	public NetBanking(String bank, String accountNumber) {
		super();
		this.bank = bank;
		this.accountNumber = accountNumber;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
}
