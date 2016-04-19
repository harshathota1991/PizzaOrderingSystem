


package com.gsu.pos.bean;

import java.io.Serializable;



public class FoodBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String foodID;
	private String foodSize;
	private String name;
	private double price;
	private int quantity;
	private String type;
	
	
	
	public final String getFoodID () {
		return this.foodID;
	}
	public final String getFoodSize () {
		return this.foodSize;
	}
	public final String getName () {
		return this.name;
	}
	public final double getPrice () {
		return this.price;
	}
	public final int getQuantity () {
		return this.quantity;
	}
	public final String getType () {
		return this.type;
	}
	public final void setFoodID (final String foodID) {
		this.foodID = foodID;
	}
	public final void setFoodSize (final String foodSize) {
		this.foodSize = foodSize;
	}
	public final void setName (final String name) {
		this.name = name;
	}
	public final void setPrice (final double price) {
		this.price = price;
	}
	public final void setQuantity (final int quantity) {
		this.quantity = quantity;
	}
	public final void setType (final String type) {
		this.type = type;
	}
}
