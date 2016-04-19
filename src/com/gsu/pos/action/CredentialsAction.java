

package com.gsu.pos.action;


import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;

import com.gsu.pos.bean.CredentialsBean;
import com.gsu.pos.util.UserImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;



public class CredentialsAction extends ActionSupport implements
		ModelDriven<CredentialsBean> {

	private static final long serialVersionUID = -7508818290761936589L;
	String result = "INVALID";
	String newPassword;
	String confirmPassword;
	String oldPassword;
	String action;
	CredentialsBean bean = new CredentialsBean();
	@Override
	public String execute () {
		System.out.println("Action is : "+this.action);
		if ("login".equals(action)) {
			UserImpl user = new UserImpl();
			result = user.login(bean);
			if (result.equals("INVALID")) {
				addActionError("Invalid credentials, Please try agian");
			} else {
				// session
				Map request = ActionContext.getContext().getSession();
				request.put("credentials", bean);
			}
		} else if ("changePasswordCustomer".equals(action)) {
			UserImpl userImpl = new UserImpl();
			Map request = ActionContext.getContext().getSession();
			bean = (CredentialsBean) request.get("credentials");
			if (bean.getPassword().equals(oldPassword)) {
				result = userImpl.changePassword(bean, newPassword);
				userImpl.logout(bean.getUserID());
			} else {
				addActionError("Enter your old Password correctly");
			}
		}else if ("changePassword".equals(action)) {
			UserImpl userImpl = new UserImpl();
			Map request = ActionContext.getContext().getSession();
			bean = (CredentialsBean) request.get("credentials");
			if (bean.getPassword().equals(oldPassword)) {
				result = userImpl.changePassword(bean, newPassword);
				userImpl.logout(bean.getUserID());
			} else {
				addActionError("Enter your old Password correctly");
			}
		} 
		else {
			UserImpl userImpl = new UserImpl();
			SessionMap session = (SessionMap) ActionContext.getContext()
					.getSession();
			// Map session=(Map)ActionContext.getContext().getSession();
			CredentialsBean credentialsBean = (CredentialsBean) session
					.get("credentials");
			String userId = credentialsBean.getUserID();
			boolean b = userImpl.logout(userId);
			CredentialsBean credentialsbean = new CredentialsBean();
			SessionMap request = (SessionMap) ActionContext.getContext()
					.getSession();
			// Map session=(Map)ActionContext.getContext().getSession();
			CredentialsBean bean = (CredentialsBean) request.get("credentials");
			session.invalidate();
			request.invalidate();
			if (b == true) {
				result = "SUCCESS";
			}
		}
		return result;
	}
	public String getAction () {
		return action;
	}
	public String getConfirmPassword () {
		return confirmPassword;
	}
	@Override
	public CredentialsBean getModel () {
		return bean;
	}
	public String getNewPassword () {
		return newPassword;
	}
	public String getOldPassword () {
		return oldPassword;
	}
	public void setAction (final String action) {
		this.action = action;
	}
	public void setConfirmPassword (final String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public void setNewPassword (final String newPassword) {
		this.newPassword = newPassword;
	}
	public void setOldPassword (final String oldPassword) {
		this.oldPassword = oldPassword;
	}
}
