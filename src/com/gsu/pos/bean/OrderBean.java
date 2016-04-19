


package com.gsu.pos.bean;


import java.io.Serializable;
import java.sql.Date;



public class OrderBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String orderID;
	private String userID;
	private Date orderDate;
	private String storeID;
	private double totalPrice;
	private String orderStatus;
	private String street;
	private String city;
	private String state;
	private String pincode;
	private String mobileNo;
	private int cartID;
	public final int getCartID () {
		return this.cartID;
	}
	public final String getCity () {
		return this.city;
	}
	public final String getMobileNo () {
		return this.mobileNo;
	}
	public final Date getOrderDate () {
		return this.orderDate;
	}
	public final String getOrderID () {
		return this.orderID;
	}
	public final String getOrderStatus () {
		return this.orderStatus;
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
	public final double getTotalPrice () {
		return this.totalPrice;
	}
	public final String getUserID () {
		return this.userID;
	}
	public final void setCartID (final int cartID) {
		this.cartID = cartID;
	}
	public final void setCity (final String city) {
		this.city = city;
	}
	public final void setMobileNo (final String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public final void setOrderDate (final Date orderDate) {
		this.orderDate = orderDate;
	}
	public final void setOrderID (final String orderID) {
		this.orderID = orderID;
	}
	public final void setOrderStatus (final String orderStatus) {
		this.orderStatus = orderStatus;
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
	public final void setTotalPrice (final double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public final void setUserID (final String userID) {
		this.userID = userID;
	}
}
