

package com.gsu.pos.action;


import java.util.ArrayList;

import com.gsu.pos.bean.StoreBean;
import com.gsu.pos.service.AdministratorImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;



public class StoreAction extends ActionSupport implements
		ModelDriven<StoreBean> {

	AdministratorImpl administrator = new AdministratorImpl();
	private static final long serialVersionUID = 1L;
	private String action;
	private StoreBean storebean;
	private ArrayList<String> storeidList;
	private ArrayList<StoreBean> storeList;
	StoreBean storeBean = new StoreBean();
	String result = "INVALID";

	@Override
	public String execute () {
System.out.println();
		if ("viewStore".equals(this.action)) {
			System.out.println("inside view store action");
			this.storeList = administrator.viewAllStore();
			if (this.storeList.size() != 0) {
				result = "SUCCESS";
			} else {
				this.addActionError("No records found");
			}

		}
		else if("addStore".equals(this.action)){
		result = administrator.addStore(storeBean);
		System.out.println(result);
		addActionMessage("Store added successfully");
		}
		else if ("viewAllStoreId".equals(this.action)) {
			this.storeidList = administrator.viewAllStoreId();
			if (this.storeidList.size() != 0) {
				result = "SUCCESS";
			} else {
				this.addActionError("No Records Found");
			}
		}
		else if ("viewByStoreId".equals(this.action)) {
			this.storebean = administrator.viewStore(this.storebean.getStoreID());
			if (this.storebean != null) {
				result = "SUCCESS";
			}
		}
		else if ("modifyStore".equals(this.action)) {
			boolean value = administrator.modifyStore(this.storebean);
			if (value) {
				this.addActionMessage("Store modified successfully");
				result = "SUCCESS";
			}
		}
		else if ("viewAllStoreIdDelete".equals(this.action)) {
			this.storeidList = administrator.viewAllStoreId();
			if (this.storeidList.size() != 0) {
				result = "SUCCESS";
			} else {
				this.addActionError("No Records Found");
			}
		}
		else if ("viewByStoreId1".equals(this.action)) {
			this.storebean = administrator.viewStore(this.storebean.getStoreID());
			if (this.storebean != null) {
				result = "SUCCESS";
			}
		}
		else {
			ArrayList<String> storeId = new ArrayList<String> ();
			storeId.add(storebean.getStoreID());
			int value = administrator.removeStore(storeId);
			if (value != 0) {
				result = "SUCCESS";
				this.addActionMessage("Record Deleted Successfully");
			}
			else
			{
				addActionMessage("Store Details are available in Users order.");
			}
		}

		return result;
	}
	public final String getAction () {
		return this.action;
	}







	@Override
	public StoreBean getModel () {
		// TODO Auto-generated method stub
		return storeBean;
	}
	public final StoreBean getStorebean () {
		return this.storebean;
	}
	public final ArrayList<String> getStoreidList () {
		return this.storeidList;
	}
	public final ArrayList<StoreBean> getStoreList () {
		return this.storeList;
	}
	public final void setAction (final String action) {
		this.action = action;
	}
	public final void setStorebean (final StoreBean storebean) {
		this.storebean = storebean;
	}
	public final void setStoreidList (final ArrayList<String> storeidList) {
		this.storeidList = storeidList;
	}
	public final void setStoreList (final ArrayList<StoreBean> storeList) {
		this.storeList = storeList;
	}















}
