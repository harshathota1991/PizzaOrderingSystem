

package com.gsu.pos.action;


import java.util.ArrayList;

import com.gsu.pos.bean.FoodBean;
import com.gsu.pos.service.AdministratorImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


public class FoodAction extends ActionSupport implements ModelDriven<FoodBean> {

	FoodBean foodBean = new FoodBean();
	AdministratorImpl administrator = new AdministratorImpl();
	private ArrayList<FoodBean> foodList;
	private ArrayList<String> foodidList;
		private String action;
	@Override
	public String execute () {
		String result = "INVALID";
		if("addFoodDetails".equals(this.action))
		{
		AdministratorImpl administratorImpl = new AdministratorImpl();
		result = administratorImpl.addFood(foodBean);
		if (result.equals("FAIL")) {
			addActionError("Adding Food Failed, Please try agian");
		} else {
			addActionMessage("Food Added successfully");
			result = "SUCCESS";
		}
		}
		else if ("viewFood".equals(this.action)) {
			System.out.println("inside view food action");
			this.foodList = administrator.viewAllFood("");
			if (this.foodList.size() != 0) {
				result = "SUCCESS";
			} else {
				this.addActionError("No records found");
			}

		}else if ("viewAllFoodIdDelete".equals(this.action)) {
			this.foodidList = administrator.viewAllFoodId();
			if (this.foodidList.size() != 0) {
				result = "SUCCESS";
			} else {
				this.addActionError("No Records Found");
			}
		}
		else if ("viewByFoodId1".equals(this.action)) {
			AdministratorImpl administratorImpl = new AdministratorImpl();
			System.out.println("inside view food by id");
			this.foodBean =administratorImpl.viewFood(this.foodBean.getFoodID());

			if (this.foodBean != null) {
				result = "SUCCESS";
			}
		}
		else if("deleteFood".equals(this.action)) {
			String foodId =null;
			foodId=foodBean.getFoodID();
			boolean value = administrator.removeFood(null,foodId);
			if (value != false) {
				result = "SUCCESS";
				this.addActionMessage("Record Deleted Successfully");
			}
			else
			{
				addActionMessage("The food is available in users order....!!!");
			}
		}
		else if ("viewAllFoodId".equals(this.action)) {
			this.foodidList = administrator.viewAllFoodId();
			if (this.foodidList.size() != 0) {
				result = "SUCCESS";
			} else {
				this.addActionError("No Records Found");
			}
		}
		else if ("viewByFoodId".equals(this.action)) {
			this.foodBean = administrator.viewFood(this.foodBean.getFoodID());
			if (this.foodBean != null) {
				result = "SUCCESS";
			}
		}
		else if ("modifyFood".equals(this.action)) {
			boolean value = administrator.modifyFood(this.foodBean);
			if (value) {
				this.addActionMessage("Successfully record updated,Do  you want to modify another data?");
				result = "SUCCESS";
			}
		}
		return result;
	}
	public String getAction () {
		return action;
	}

	public FoodBean getFoodBean () {
		return foodBean;
	}

	public ArrayList<String> getFoodidList () {
		return foodidList;
	}

	public ArrayList<FoodBean> getFoodList () {
		return foodList;
	}

	@Override
	public FoodBean getModel () {
		return foodBean;
	}

	public void setAction (final String action) {
		this.action = action;
	}

	public void setFoodBean (final FoodBean foodBean) {
		this.foodBean = foodBean;
	}

	public void setFoodidList (final ArrayList<String> foodidList) {
		this.foodidList = foodidList;
	}
	public void setFoodList (final ArrayList<FoodBean> foodList) {
		this.foodList = foodList;
	}

}
