


package com.gsu.pos.bean;


import java.io.Serializable;
import java.util.Date;



public class ProfileBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String userID;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private String gender;
	private String street;
	private String location;
	private String city;
	private String state;
	private String pincode;
	private String mobileNo;
	private String emailID;
	private String password;
	private String confirmPassword;
	public final String getCity () {
		return this.city;
	}
	public final String getConfirmPassword () {
		return this.confirmPassword;
	}
	public final Date getDateOfBirth () {
		return this.dateOfBirth;
	}
	public final String getEmailID () {
		return this.emailID;
	}
	public final String getFirstName () {
		return this.firstName;
	}
	public final String getGender () {
		return this.gender;
	}
	public final String getLastName () {
		return this.lastName;
	}
	public final String getLocation () {
		return this.location;
	}
	public final String getMobileNo () {
		return this.mobileNo;
	}
	public final String getPassword () {
		return this.password;
	}
	public final String getPincode () {
		return this.pincode;
	}
	public final String getState () {
		return this.state;
	}
	public final String getStreet () {
		return this.street;
	}
	public final String getUserID () {
		return this.userID;
	}
	public final void setCity (final String city) {
		this.city = city;
	}
	public final void setConfirmPassword (final String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public final void setDateOfBirth (final Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public final void setEmailID (final String emailID) {
		this.emailID = emailID;
	}
	public final void setFirstName (final String firstName) {
		this.firstName = firstName;
	}
	public final void setGender (final String gender) {
		this.gender = gender;
	}
	public final void setLastName (final String lastName) {
		this.lastName = lastName;
	}
	public final void setLocation (final String location) {
		this.location = location;
	}
	public final void setMobileNo (final String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public final void setPassword (final String password) {
		this.password = password;
	}
	public final void setPincode (final String pincode) {
		this.pincode = pincode;
	}
	public final void setState (final String state) {
		this.state = state;
	}
	public final void setStreet (final String street) {
		this.street = street;
	}
	public final void setUserID (final String userID) {
		this.userID = userID;
	}
}
