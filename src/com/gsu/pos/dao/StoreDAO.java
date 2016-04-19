


package com.gsu.pos.dao;




import java.util.ArrayList;

import com.gsu.pos.bean.StoreBean;



public interface StoreDAO {

	String createStore (StoreBean storebean);
	int deleteStore (ArrayList<String> storeId);
	ArrayList<StoreBean> findAll ();
	public ArrayList<String> findAllID ();
	StoreBean findByID (String storeId);
	boolean updateStore (StoreBean storebean);
}
