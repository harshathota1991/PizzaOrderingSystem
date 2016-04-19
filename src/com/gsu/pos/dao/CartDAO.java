


package com.gsu.pos.dao;




import java.util.ArrayList;

import com.gsu.pos.bean.CartBean;
import com.gsu.pos.bean.StoreBean;



public interface CartDAO {

	String createCart (CartBean cartbean);

	int deleteCart (ArrayList<String> cartId);
	ArrayList<CartBean> findAll ();
	public ArrayList<CartBean> findAll (final int cartID);
	CartBean findByID (String cartId);
	public ArrayList<String> findCity ();



	public ArrayList<StoreBean> findStore (final String city);
	public int getSerialNum();

	boolean updateCart (CartBean cartbean);
}
