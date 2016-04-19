

package com.gsu.pos.action;


import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;

import com.gsu.pos.bean.CartBean;
import com.gsu.pos.bean.CredentialsBean;
import com.gsu.pos.bean.FoodBean;
import com.gsu.pos.bean.OrderBean;
import com.gsu.pos.bean.StoreBean;
import com.gsu.pos.service.AdministratorImpl;
import com.gsu.pos.service.CustomerImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;



public class CartAction extends ActionSupport implements ModelDriven<CartBean> {

	FoodBean foodBean = new FoodBean();
	AdministratorImpl administrator = new AdministratorImpl();
	private ArrayList<FoodBean> foodList;
	CustomerImpl customerImpl = new CustomerImpl();
	private StoreBean storebean = new StoreBean();
	private String action;
	private ArrayList<String> storeCityList;
	private ArrayList<StoreBean> storeList;
	private String result = "INVALID";
	private String foodQty;
	private Map<Integer, Boolean> foodCheck;
	private Map<Integer, String> selectedValue;
	CartBean cartBean = new CartBean();
	ArrayList<OrderBean> orderArrayList = new ArrayList<OrderBean>();
	Date dt = new Date();
	private int subScript = 0;
	private String[] FoodQuantitySplitDuplicate = null;
	SessionMap session = (SessionMap) ActionContext.getContext().getSession();
	SessionMap sessionCart = (SessionMap) ActionContext.getContext()
			.getSession();
	SessionMap sessionArrayList = (SessionMap) ActionContext.getContext()
			.getSession();
	SessionMap sessionStore = (SessionMap) ActionContext.getContext()
			.getSession();
	SessionMap sessionOrder = (SessionMap) ActionContext.getContext()
			.getSession();
	int check = 0;
	int serialNum;
	ArrayList<CartBean> arrayList = new ArrayList<CartBean>();
	@Override
	public String execute () {
		CredentialsBean credentialsBean = (CredentialsBean) session
				.get("credentials");
		String userId = credentialsBean.getUserID();
		System.out.println("action   " + action);
		if ("selectCity".equals(this.action)) {
			serialNum = customerImpl.serialNumber();
			sessionCart.put("cardId", serialNum);
			int dummy = (Integer) sessionCart.get("cardId");
			cartBean.setCartID(dummy);
			storeCityList = customerImpl.viewCity();
			if (storeCityList.size() != 0) {
				result = "SUCCESS";
			}
		} else if ("viewStoreIdByCity".equals(this.action)) {
			storeList = customerImpl.viewStore(this.storebean.getCity());
			if (storeList.size() != 0) {
				result = "SUCCESS";
			}
		} else if ("viewFoodDetails".equals(this.action)) {
			System.out.println("------------->store id"
					+ this.storebean.getStoreID());
			String storeID = storebean.getStoreID();
			sessionStore.put("sessionStoreKey", this.storebean.getStoreID());
			storeID = (String) sessionStore.get("sessionStoreKey");
			if (storeID instanceof String) {
				this.foodList = administrator.viewAllFood("");
				sessionStore.put("foodList", this.foodList);
				if (this.foodList.size() != 0) {
					result = "SUCCESS";
				} else {
					this.addActionError("No records found");
				}
			} else {
				result = "INVALID";
			}
		} else if ("addCart".equals(this.action)) {
			int a=0;
			for (int i = 0; i < foodCheck.size(); i++) {
				if (foodCheck.get(i)) {
					
					foodList = (ArrayList<FoodBean>) sessionStore.get("foodList");
					CartBean cartbean = new CartBean();
					FoodBean food = foodList.get(i);
					food.setQuantity(Integer.parseInt(selectedValue.get(i)));
					if (food.getQuantity() > 0) {
						a=a+1;
						int dummy = (Integer) sessionCart.get("cardId");
						System.out.println(dummy + "-------------");
						cartbean.setCartID(dummy);
						double cost = food.getPrice() * food.getQuantity();
						cartbean.setCost(cost);
						cartbean.setQuantity(food.getQuantity());
						cartbean.setOrderDate(dt);
						cartbean.setType(food.getType());
						cartbean.setUserID(userId);
						cartbean.setFoodID(food.getFoodID());
						int value = customerImpl.addToCart(cartbean);
						if (value != 0) {
							result = "SUCCESS";
							arrayList = customerImpl.viewCart(cartbean
									.getCartID());
							sessionArrayList.put("arrayListSession", arrayList);
						}
					}
				}
				
				
			}
			if(a==0)
			{
				String storeID =storeID = (String) sessionStore.get("sessionStoreKey");
				System.out.println("store id.????????????"+storeID);
				if (storeID instanceof String) {
					int dummy = (Integer) sessionCart.get("cardId");
					cartBean.setCartID(dummy);
					this.foodList = administrator.viewAllFoodByCartID(cartBean
							.getCartID());
					sessionStore.put("foodList", this.foodList);
					if (this.foodList.size() != 0) {
						result = "showCart";
						System.out.println("error");
						addActionMessage("Choose The correct the selection to add in the cart");
					}
				}
				
			}
			System.out.println("integer value"+a);
		} else if ("mCart".equals(this.action)) {
			int cartid = (Integer) sessionCart.get("cardId");
			cartBean.setCartID(cartid);
			System.out.println("cart id from session" + cartBean.getCartID());
			arrayList = customerImpl.viewCart(cartBean.getCartID());
			System.out.println(arrayList.size() + "array list size");
			if (arrayList.size() > 0) {
				result = "SUCCESS";
			}
		} else if ("modifyCartDetails".equals(this.action)) {
			boolean value = true;
			SessionMap session = (SessionMap) ActionContext.getContext()
					.getSession();
			CartBean cBean = new CartBean();
			arrayList = (ArrayList<CartBean>) session.get("arrayListSession");
			for (int index = 0; index < arrayList.size();) {
				String quantity1 = getFoodQty().trim();
				String[] quantitySplit = quantity1.split(",");
				
				int no1 = 0;
				System.out
						.println("-------------else2i222222222222222222222222222222222e"
								+ foodBean.getFoodID());
				if (foodBean.getFoodID() instanceof String ){//|| !foodBean.getFoodID().equals("false")) {
					System.out
							.println("-------------else2i222222222222222222222222222222222e");
					String foodid1 = foodBean.getFoodID().trim();
					System.out.println(foodBean.getFoodID());
					String[] foodidSplit = foodid1.split(",");
					for (String element : quantitySplit) {
						cBean = arrayList.get(index);
						if (foodidSplit.length > no1
								&& cBean.getFoodID().equals(
										foodidSplit[no1].trim())&&(!quantity1.trim().equals(""))) {
							int quantity = Integer.parseInt(element.trim());
							cartBean.setQuantity(quantity);
							cartBean.setFoodID(foodidSplit[no1].trim());
							double c = cBean.getCost();
							c = c / cBean.getQuantity();
							cartBean.setCost(c * quantity);
							cartBean.setCartID(cBean.getCartID());
							value = customerImpl.modifyCart(cartBean);
							System.out.println("vaulueasdhkasjdgfkasgfd"+value);
							no1++;
						}
						index++;
					}
					if (value) {
						addActionMessage("You have not selected any foodid to modify...!!!");
						this.addActionMessage("Successfully record updated,Do  you want to modify another data?");
						result = "SUCCESS";
						int cartid = (Integer) sessionCart.get("cardId");
						cartBean.setCartID(cartid);
						System.out.println("cart id from session"
								+ cartBean.getCartID());
						arrayList = customerImpl.viewCart(cartBean.getCartID());
						if (arrayList.size() > 0) {
							result = "SUCCESS";
						}
					}
				} else {
					addActionMessage("You have not selected any foodid to modify...!!!");
					result = "showCart";
					CartBean cartbean = new CartBean();
					int dummy = (Integer) sessionCart.get("cardId");
					System.out
							.println(dummy
									+ "-------------elseeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
					cartbean.setCartID(dummy);
					arrayList = customerImpl.viewCart(cartbean.getCartID());
					index++;
				}
			}
		} else if ("confirmCart".equals(action)) {
			int cartid = (Integer) sessionCart.get("cardId");
			String storekey = (String) sessionStore.get("sessionStoreKey");
			cartBean.setCartID(cartid);
			System.out.println("cart id from session" + cartBean.getCartID());
			arrayList = customerImpl.viewCart(cartBean.getCartID());
			System.out.println(arrayList.size()
					+ "array list size in confiem status");
			result = customerImpl.confirmOrder(arrayList, storekey);
			OrderBean orderBean = new OrderBean();
			System.out.println("###############@@@@@@@@@@@"
					+ cartBean.getCartID());
			orderBean = customerImpl.viewOrderByCartid(cartBean.getCartID());
			orderArrayList.add(orderBean);
			sessionOrder.put("sessionOrderKey", orderBean);
			addActionError("done inside confirm cart");
		}
		else if ("addToCart".equals(action)) {
			int dummy = (Integer) sessionCart.get("cardId");
			cartBean.setCartID(dummy);
			this.foodList = administrator.viewAllFoodByCartID(cartBean
					.getCartID());
			sessionStore.put("foodList", this.foodList);
			foodList=(ArrayList<FoodBean>) sessionStore.get("foodList");
			System.out.println("food bean size in add to cart"+foodList.size());
			System.out.println("cart id 000" + cartBean.getCartID());
			if (this.foodList.size() != 0) {
				System.out.println("food list after inserting in to cart "+foodList.size());
				result = "SUCCESS";
			} else {
				this.addActionError("No records found");
			}
		} 
		return result;
	}
	public String getAction () {
		return action;
	}
	public ArrayList<CartBean> getArrayList () {
		return arrayList;
	}
	public FoodBean getFoodBean () {
		return foodBean;
	}
	public Map<Integer, Boolean> getFoodCheck () {
		return foodCheck;
	}
	public ArrayList<FoodBean> getFoodList () {
		return foodList;
	}
	public String getFoodQty () {
		return foodQty;
	}
	@Override
	public CartBean getModel () {
		// TODO Auto-generated method stub
		return cartBean;
	}
	public ArrayList<OrderBean> getOrderArrayList () {
		return orderArrayList;
	}
	public Map<Integer, String> getSelectedValue () {
		return selectedValue;
	}
	public StoreBean getStorebean () {
		return storebean;
	}
	public ArrayList<String> getStoreCityList () {
		return storeCityList;
	}
	public ArrayList<StoreBean> getStoreList () {
		return storeList;
	}
	public void setAction (final String action) {
		this.action = action;
	}
	public void setArrayList (final ArrayList<CartBean> arrayList) {
		this.arrayList = arrayList;
	}
	public void setFoodBean (final FoodBean foodBean) {
		this.foodBean = foodBean;
	}
	public void setFoodCheck (final Map<Integer, Boolean> foodCheck) {
		this.foodCheck = foodCheck;
	}
	public void setFoodList (final ArrayList<FoodBean> foodList) {
		this.foodList = foodList;
	}
	public void setFoodQty (final String foodQty) {
		this.foodQty = foodQty;
	}
	public void setOrderArrayList (final ArrayList<OrderBean> orderArrayList) {
		this.orderArrayList = orderArrayList;
	}
	public void setSelectedValue (final Map<Integer, String> selectedValue) {
		this.selectedValue = selectedValue;
	}
	public void setStorebean (final StoreBean storebean) {
		this.storebean = storebean;
	}
	public void setStoreCityList (final ArrayList<String> storeCityList) {
		this.storeCityList = storeCityList;
	}
	public void setStoreList (final ArrayList<StoreBean> storeList) {
		this.storeList = storeList;
	}
}
