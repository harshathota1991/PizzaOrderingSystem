


package com.gsu.pos.service;


import java.util.ArrayList;

import com.gsu.pos.bean.CartBean;
import com.gsu.pos.bean.OrderBean;
import com.gsu.pos.bean.StoreBean;



public interface Customer {
	int addToCart (CartBean cartBean);
	String cancelOrder (String orderId);
	String confirmOrder (ArrayList<CartBean> cartbean);
	boolean modifyCart (CartBean cartBean);
	public int serialNumber ();
	ArrayList<CartBean> viewCart ();
	public ArrayList<CartBean> viewCart (final int cartID);
	public ArrayList<String> viewCity ();
	ArrayList<OrderBean> viewOrder ();
	ArrayList<StoreBean> viewStore (String city);
}
