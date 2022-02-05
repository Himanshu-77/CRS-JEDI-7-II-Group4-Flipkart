/**
 * 
 */
package com.flipkart.bean;

/**
 * @author Dell
 *
 */
public class Card extends Online{
	private String CardType;
	private String CardNumber;

	public Card() {
		CardType = "default";
		CardNumber = "0000-0000-0000";
	}
	public Card(String cardType, String cardNumber) {
		super();
		CardType = cardType;
		CardNumber = cardNumber;
	}
	public String getCardType() {
		return CardType;
	}
	public void setCardType(String cardType) {
		CardType = cardType;
	}
	
	public String getCardNumber() {
		return CardNumber;
	}
	public void setCardNumber(String cardNumber) {
		CardNumber = cardNumber;
	}
}
