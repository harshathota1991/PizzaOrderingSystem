

package com.gsu.pos.service;


import java.util.ArrayList;

import com.gsu.pos.bean.FoodBean;
import com.gsu.pos.bean.OrderBean;
import com.gsu.pos.bean.StoreBean;
import com.gsu.pos.dao.FoodDAOImpl;
import com.gsu.pos.dao.OrderDAOImpl;
import com.gsu.pos.dao.StoreDAOImpl;


public class AdministratorImpl implements Administrator {

	String result = "INVALID";
	@Override
	public String addFood (final FoodBean foodBean) {
		String result = "FAIL";
		String foodName = "";
		// if (foodBean instanceof FoodBean) {
		FoodDAOImpl foodDAO = new FoodDAOImpl();
		String foodID = foodDAO.findID();
		foodName = foodBean.getName();
		System.out.println(foodName);
		if (foodName != null || foodName.length() > 2) {
			foodName = foodName.substring(0, 2).toUpperCase();
			foodID = foodName + foodID;
			foodBean.setFoodID(foodID);
			// Double price = foodBean.getPrice();
			// price = price * foodBean.getQuantity();
			// foodBean.setPrice(price);
			result = foodDAO.createFood(foodBean);
			System.out.println("Result from DAO class (inside AdminImpl): "
					+ result);
			// }
		}
		return result;
	}
	public ArrayList<FoodBean> viewAllFoodByCartID (final int cartID) {
		// TODO Auto-generated method stub
		FoodDAOImpl fooddaoimpl = new FoodDAOImpl();
		ArrayList<FoodBean> foodList = fooddaoimpl.findAllByCartID(cartID);
		return foodList;
	}
	@Override
	public String addStore (final StoreBean storeBean) {
		StoreDAOImpl storeDAO = new StoreDAOImpl();
		String storeID = storeDAO.findID();
		String first = storeBean.getName();
		String two = first.substring(0, 2).toUpperCase();
		storeID = two + storeID;
		// CredentialsBean bean=new CredentialsBean();
		storeBean.setStoreID(storeID);
		result = storeDAO.createStore(storeBean);
		System.out.println("Result from DAO class (inside AdminImpl): "
				+ result);
		return result;
	}
	public String changeOrderStatus (final OrderBean orderBean) {
		// TODO Auto-generated method stub
		String resultString = "INVALID";
		OrderDAOImpl orderDAOImpl = new OrderDAOImpl();
		boolean result = orderDAOImpl.updateOrder(orderBean);
		if (result) {
			resultString = "SUCCESS";
		}
		return resultString;
	}
	@Override
	public String changeOrderStatus (final String orderId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean modifyFood (final FoodBean foodbean) {
		// TODO Auto-generated method stub
		boolean result = false;
		if (foodbean != null) {
			FoodDAOImpl fooddaoimpl = new FoodDAOImpl();
			result = fooddaoimpl.updateFood(foodbean);
		}
		return result;
	}
	@Override
	public boolean modifyStore (final StoreBean storebean) {
		// TODO Auto-generated method stub
		boolean result = false;
		if (storebean != null) {
			StoreDAOImpl storedaoimpl = new StoreDAOImpl();
			result = storedaoimpl.updateStore(storebean);
		}
		return result;
	}
	@Override
	public boolean removeFood (final String storeId, final String foodId) {
		// TODO Auto-generated method stub
		boolean result = false;
		int result1 = 0;
		ArrayList<String> foodID = new ArrayList<String>();
		foodID.add(foodId);
		if (foodID != null && foodID.size() != 0) {
			FoodDAOImpl fooddaoimpl = new FoodDAOImpl();
			result1 = fooddaoimpl.deleteFood(foodID);
		}
		if (result1 == 1) {
			result = true;
		}
		return result;
	}
	@Override
	public int removeStore (final ArrayList<String> storeId) {
		// TODO Auto-generated method stub
		int result = 0;
		if (storeId != null && storeId.size() != 0) {
			StoreDAOImpl storedaoimpl = new StoreDAOImpl();
			result = storedaoimpl.deleteStore(storeId);
		}
		return result;
	}
	@Override
	public ArrayList<FoodBean> viewAllFood (final String storeId) {
		// TODO Auto-generated method stub
		FoodDAOImpl fooddaoimpl = new FoodDAOImpl();
		ArrayList<FoodBean> foodList = fooddaoimpl.findAll();
		return foodList;
	}
	@Override
	public ArrayList<String> viewAllFoodId () {
		FoodDAOImpl fooddaoimpl = new FoodDAOImpl();
		ArrayList<String> idList = fooddaoimpl.findAllID();
		return idList;
	}
	@Override
	public ArrayList<StoreBean> viewAllStore () {
		// TODO Auto-generated method stub
		StoreDAOImpl storedaoimpl = new StoreDAOImpl();
		ArrayList<StoreBean> storeList = storedaoimpl.findAll();
		return storeList;
	}
	@Override
	public ArrayList<String> viewAllStoreId () {
		StoreDAOImpl storedaoimpl = new StoreDAOImpl();
		ArrayList<String> idList = storedaoimpl.findAllID();
		return idList;
	}
	@Override
	public FoodBean viewFood (final String foodId) {
		// TODO Auto-generated method stub
		FoodBean foodbean = null;
		System.out.println("inside view food" + foodId);
		if (foodId != null) {
			FoodDAOImpl fooddaoimpl = new FoodDAOImpl();
			foodbean = fooddaoimpl.findByID(foodId);
			// System.out.println("foodsize of food bean "+foodbean.getFoodSize());
		}
		return foodbean;
	}
	@Override
	public StoreBean viewStore (final String storeId) {
		// TODO Auto-generated method stub
		StoreBean storebean = null;
		if (storeId != null) {
			StoreDAOImpl storedaoimpl = new StoreDAOImpl();
			storebean = storedaoimpl.findByID(storeId);
		}
		return storebean;
	}
}
