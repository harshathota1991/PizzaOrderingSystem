
 

package com.gsu.pos.bean;


import java.io.Serializable;
import java.util.Date;



public class CartBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private int cartID;
	private String userID;
	private String foodID;
	private String type;
	private int quantity;
	private double cost;
	private Date orderDate;
	public final int getCartID () {
		return this.cartID;
	}
	public final double getCost () {
		return this.cost;
	}
	public final String getFoodID () {
		return this.foodID;
	}
	public final Date getOrderDate () {
		return this.orderDate;
	}
	public final int getQuantity () {
		return this.quantity;
	}
	public final String getType () {
		return this.type;
	}
	public final String getUserID () {
		return this.userID;
	}
	public final void setCartID (final int cartID) {
		this.cartID = cartID;
	}
	public final void setCost (final double cost) {
		this.cost = cost;
	}
	public final void setFoodID (final String foodID) {
		this.foodID = foodID;
	}
	public final void setOrderDate (final Date orderDate) {
		this.orderDate = orderDate;
	}
	public final void setQuantity (final int quantity) {
		this.quantity = quantity;
	}
	public final void setType (final String type) {
		this.type = type;
	}
	public final void setUserID (final String userID) {
		this.userID = userID;
	}
}
