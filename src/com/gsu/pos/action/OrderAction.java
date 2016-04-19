

package com.gsu.pos.action;


import java.util.ArrayList;

import org.apache.struts2.dispatcher.SessionMap;

import com.gsu.pos.bean.CredentialsBean;
import com.gsu.pos.bean.OrderBean;
import com.gsu.pos.service.AdministratorImpl;
import com.gsu.pos.service.CustomerImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;



public class OrderAction extends ActionSupport {

	String action, orderStatus;
	String result = "INVALID";
	String orderID;
	OrderBean orderBean = new OrderBean();
	ArrayList<OrderBean> arrayList = new ArrayList<OrderBean>();
	@Override
	public String execute () {
		if ("ordercancel".equals(action)) {
			CustomerImpl customerImpl = new CustomerImpl();
			SessionMap request = (SessionMap) ActionContext.getContext()
					.getSession();
			CredentialsBean credentialsBean = (CredentialsBean) request
					.get("credentials");
			String orderID = credentialsBean.getUserID();
			arrayList = customerImpl.viewOrderByOrderID(orderID);
			result = "SUCCESS";
		} else if ("deleteOrder".equals(action)) {
			CustomerImpl customerImpl = new CustomerImpl();
			customerImpl.cancelOrder(getOrderID());
			System.out.println("@@@@@@#####@@@@@@@@@###########@@@@@@@"
					+ orderID);
			addActionMessage("delete is done");
			result = "SUCCESS";
		} else if ("OrderDetails".equals(action)) {
			CustomerImpl customerImpl = new CustomerImpl();
			arrayList = customerImpl.viewOrder();
			if (!arrayList.isEmpty()) {
				result = "SUCCESS";
			}
		} else if ("orderProcess".equals(action)) {
			if ("Pending".equals(orderStatus)) {
				orderBean.setOrderStatus("Pending");
			} else if ("Delivered".equals(orderStatus)) {
				orderBean.setOrderStatus("Delivered");
			} else if ("Confirmed".equals(orderStatus)) {
				orderBean.setOrderStatus("Confirmed");
			} else if ("Cancelled".equals(orderStatus)) {
				orderBean.setOrderStatus("Cancelled");
			}
			AdministratorImpl administratorImpl = new AdministratorImpl();
			String[] orderIdLocal = orderID.split(",");
			for (int i = 0; i < orderIdLocal.length; i++) {
				orderBean.setOrderID(orderIdLocal[i]);
				result = administratorImpl.changeOrderStatus(orderBean);
			}
			addActionMessage("Order Status modified");
		}
		return result;
	}
	public String getAction () {
		return action;
	}
	public ArrayList<OrderBean> getArrayList () {
		return arrayList;
	}
	public OrderBean getOrderBean () {
		return orderBean;
	}
	public String getOrderID () {
		return orderID;
	}
	public String getOrderStatus () {
		return orderStatus;
	}
	public void setAction (final String action) {
		this.action = action;
	}
	public void setArrayList (final ArrayList<OrderBean> arrayList) {
		this.arrayList = arrayList;
	}
	public void setOrderBean (final OrderBean orderBean) {
		this.orderBean = orderBean;
	}
	public void setOrderID (final String orderID) {
		this.orderID = orderID;
	}
	public void setOrderStatus (final String orderStatus) {
		this.orderStatus = orderStatus;
	}
}
