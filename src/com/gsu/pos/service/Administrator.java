


package com.gsu.pos.service;



import java.util.ArrayList;

import com.gsu.pos.bean.FoodBean;
import com.gsu.pos.bean.StoreBean;


public interface Administrator {
	String addFood (FoodBean foodbean);
	String addStore (final StoreBean storebean);
	String changeOrderStatus (String orderId);
	boolean modifyFood (final FoodBean foodbean);
	boolean modifyStore (final StoreBean storebean);
	boolean removeFood (String storeId, String foodId);
	int removeStore (ArrayList<String> storeId);
	ArrayList<FoodBean> viewAllFood (String storeId);
	ArrayList<String> viewAllFoodId ();
	ArrayList<StoreBean> viewAllStore ();
	public ArrayList<String>viewAllStoreId ();
	FoodBean viewFood (String foodId);
	StoreBean viewStore (String storeId);
}
