


package com.gsu.pos.bean;


import java.io.Serializable;



public class CredentialsBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String userID;
	private String password;
	private String userType;
	private int loginStatus;
	public final int getLoginStatus () {
		return this.loginStatus;
	}
	public final String getPassword () {
		return this.password;
	}
	public final String getUserID () {
		return this.userID;
	}
	public final String getUserType () {
		return this.userType;
	}
	public final void setLoginStatus (final int loginStatus) {
		this.loginStatus = loginStatus;
	}
	public final void setPassword (final String password) {
		this.password = password;
	}
	public final void setUserID (final String userID) {
		this.userID = userID.toUpperCase();
	}
	public final void setUserType (final String userType) {
		this.userType = userType;
	}
}
