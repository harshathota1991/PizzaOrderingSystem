

package com.gsu.pos.service;


import java.util.ArrayList;

import com.gsu.pos.bean.CartBean;
import com.gsu.pos.bean.OrderBean;
import com.gsu.pos.bean.ProfileBean;
import com.gsu.pos.bean.StoreBean;
import com.gsu.pos.dao.CartDAOImpl;
import com.gsu.pos.dao.OrderDAOImpl;
import com.gsu.pos.dao.UserProfileDAOImpl;


public class CustomerImpl implements Customer {

	CartDAOImpl cartDAOImpl = new CartDAOImpl();
	ProfileBean profileBean = new ProfileBean();
	int totalPrice;
	@Override
	public int addToCart (final CartBean cartBean) {
		// TODO Auto-generated method stub
		int result = 0;
		if ("SUCCESS".equals(cartDAOImpl.createCart(cartBean))) {
			result = 1;
		}
		return result;
	}
	@Override
	public String cancelOrder (final String orderId) {
		// TODO Auto-generated method stub
		String result = "INVALID";
		OrderDAOImpl orderDAOImpl = new OrderDAOImpl();
		if (orderDAOImpl.deleteOrderByID(orderId) > 0) {
			result = "SUCCESS";
		}
		return result;
	}
	@Override
	public String confirmOrder (final ArrayList<CartBean> cartbean) {
		return null;
	}
	public String confirmOrder (final ArrayList<CartBean> cartbean,
			final String storeID) {
		// TODO Auto-generated method stub
		// ArrayList<CartBean> arrayList = new ArrayList<CartBean>();
		// arrayList = cartbean;
		CartBean cartBeanObject = new CartBean();
		OrderDAOImpl orderDAOImpl = new OrderDAOImpl();
		OrderBean orderbean = new OrderBean();
		ProfileBean profileBeanLocal = new ProfileBean();
		int size = cartbean.size();
		for (int i = 0; i < size; i++) {
			cartBeanObject = cartbean.get(i);
			totalPrice = (int) (cartBeanObject.getCost() + totalPrice);
		}
		orderbean.setTotalPrice(totalPrice);
		cartBeanObject = cartbean.get(0);
		orderDAOImpl.createOrder(orderbean);
		orderbean.setUserID(cartBeanObject.getUserID());
		orderbean.setOrderDate((java.sql.Date) cartBeanObject.getOrderDate());
		orderbean.setStoreID(storeID);
		System.out.println("store id"+cartBeanObject.getUserID());
		orderbean.setOrderStatus("Pending");
		orderbean.setCartID(cartBeanObject.getCartID());
		profileBeanLocal = userDetail(cartBeanObject.getUserID());
		orderbean.setStreet(profileBeanLocal.getStreet());
		orderbean.setCity(profileBeanLocal.getCity());
		orderbean.setState(profileBeanLocal.getState());
		orderbean.setPincode(profileBeanLocal.getPincode());
		orderbean.setMobileNo(profileBeanLocal.getMobileNo());
		return orderDAOImpl.createOrder(orderbean);
	}
	@Override
	public boolean modifyCart (final CartBean cartBean) {
		// TODO Auto-generated method stub
		boolean result = false;
		result = cartDAOImpl.updateCart(cartBean);
		return result;
	}
	@Override
	public int serialNumber () {
		int sequenceNo;
		CartDAOImpl cartDAOImpl = new CartDAOImpl();
		sequenceNo = cartDAOImpl.getSerialNum();
		return sequenceNo;
	}
	public ProfileBean userDetail (final String userID) {
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		UserProfileDAOImpl profileDaoImpl = new UserProfileDAOImpl();
		profileBean = profileDaoImpl.findByID(userID);
		return profileBean;
	}
	@Override
	public ArrayList<CartBean> viewCart () {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ArrayList<CartBean> viewCart (final int cartID) {
		CartBean cartBean = new CartBean();
		// System.out.println("cart id from bean======>>>"+cartBean.getCartID());
		ArrayList<CartBean> arrayList = new ArrayList<CartBean>();
		CartDAOImpl cartDAOImpl = new CartDAOImpl();
		return cartDAOImpl.findAll(cartID);
	}
	@Override
	public ArrayList<String> viewCity () {
		// TODO Auto-generated method stub
		ArrayList<String> arrayCityList = new ArrayList<String>();
		CartDAOImpl cartDAOImpl = new CartDAOImpl();
		arrayCityList = cartDAOImpl.findCity();
		// System.out.println("customer impl "+arrayCityList.size());
		return arrayCityList;
	}
	@Override
	public ArrayList<OrderBean> viewOrder () {
		// TODO Auto-generated method stub
		OrderDAOImpl orderDAOImpl = new OrderDAOImpl();
		// ArrayList<OrderBean> orderArrayList = new ArrayList<OrderBean>();
		return orderDAOImpl.findAll();
	}
	public OrderBean viewOrderByCartid (final int cartID) {
		// TODO Auto-generated method stub
		OrderDAOImpl orderDAOImpl = new OrderDAOImpl();
		// ArrayList<OrderBean> orderArrayList = new ArrayList<OrderBean>();
		return orderDAOImpl.findByID(cartID);
	}
	public ArrayList<OrderBean> viewOrderByOrderID (final String orderID) {
		// TODO Auto-generated method stub
		OrderDAOImpl orderDAOImpl = new OrderDAOImpl();
		// ArrayList<OrderBean> orderArrayList = new ArrayList<OrderBean>();
		return orderDAOImpl.findByOrderID(orderID);
	}
	@Override
	public ArrayList<StoreBean> viewStore (final String city) {
		// TODO Auto-generated method stub
		ArrayList<StoreBean> arrayList = new ArrayList<StoreBean>();
		CartDAOImpl cartDAOImpl = new CartDAOImpl();
		arrayList = cartDAOImpl.findStore(city);
		System.out.println("size of arra list" + arrayList.size());
		return arrayList;
	}
}
