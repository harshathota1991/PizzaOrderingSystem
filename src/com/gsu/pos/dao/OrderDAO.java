


package com.gsu.pos.dao;


import java.util.ArrayList;

import com.gsu.pos.bean.OrderBean;



public interface OrderDAO {

	String createOrder (OrderBean orderbean);
	int deleteOrder (ArrayList<String> orderId);
	ArrayList<OrderBean> findAll ();
	OrderBean findByID (int cartID);
	OrderBean findByID (String orderId);
	boolean updateOrder (OrderBean orderbean);
}
