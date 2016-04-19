


package com.gsu.pos.bean;

import java.io.Serializable;



public class CreditCardBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String creditcardNo;
	private String validFrom;
	private String validTo;
	private double balance;
	private String userID;
	public final double getBalance () {
		return this.balance;
	}
	public final String getCreditcardNo () {
		return this.creditcardNo;
	}
	public final String getUserID () {
		return this.userID;
	}
	public final String getValidFrom () {
		return this.validFrom;
	}
	public final String getValidTo () {
		return this.validTo;
	}
	public final void setBalance (final double balance) {
		this.balance = balance;
	}
	public final void setCreditcardNo (final String creditcardNo) {
		this.creditcardNo = creditcardNo;
	}
	public final void setUserID (final String userID) {
		this.userID = userID;
	}
	public final void setValidFrom (final String validFrom) {
		this.validFrom = validFrom;
	}
	public final void setValidTo (final String validTo) {
		this.validTo = validTo;
	}
}
