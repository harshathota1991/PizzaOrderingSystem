


package com.gsu.pos.bean;

import java.io.Serializable;



public class StoreBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String storeID;
	private String name;
	private String street;
	private String mobileNo;
	private String city;
	private String state;
	private String pincode;
	public final String getCity () {
		return this.city;
	}
	public final String getMobileNo () {
		return this.mobileNo;
	}
	public final String getName () {
		return this.name;
	}
	public final String getPincode () {
		return this.pincode;
	}
	public final String getState () {
		return this.state;
	}
	public final String getStoreID () {
		return this.storeID;
	}
	public final String getStreet () {
		return this.street;
	}

	public final void setCity (final String city) {
		this.city = city;
	}
	public final void setMobileNo (final String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public final void setName (final String name) {
		this.name = name;
	}
	public final void setPincode (final String pincode) {
		this.pincode = pincode;
	}
	public final void setState (final String state) {
		this.state = state;
	}
	public final void setStoreID (final String storeID) {
		this.storeID = storeID;
	}
	public final void setStreet (final String street) {
		this.street = street;
	}
}
