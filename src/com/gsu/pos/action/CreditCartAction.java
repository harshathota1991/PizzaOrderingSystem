

package com.gsu.pos.action;


import org.apache.struts2.dispatcher.SessionMap;

import com.gsu.pos.bean.CredentialsBean;
import com.gsu.pos.bean.CreditCardBean;
import com.gsu.pos.bean.OrderBean;
import com.gsu.pos.util.PaymentImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


public class CreditCartAction extends ActionSupport implements
		ModelDriven<CreditCardBean> {

	private CreditCardBean creditCardBean = new CreditCardBean();
	private String action;
	// Map session = ActionContext.getContext().getSession();
	SessionMap sessionOrder = (SessionMap) ActionContext.getContext()
			.getSession();
	SessionMap session = (SessionMap) ActionContext.getContext().getSession();
	@Override
	public String execute () {
		String result = "INVALID";
		// CreditCardBean creditCardBean = new CreditCardBean();
		PaymentImpl payment = new PaymentImpl();
		// CreditCardDAOImpl creditCardDAOImpl = new CreditCardDAOImpl();
		OrderBean orderBean = new OrderBean();
		// orderBean = (OrderBean) session.get();
		if ("CreditCard111".equals(action)) {
			OrderBean orderbean1 = (OrderBean) sessionOrder
					.get("sessionOrderKey");
			CredentialsBean credentialsBean = (CredentialsBean) session
					.get("credentials");
			String userID = credentialsBean.getUserID();
			System.out.println(userID + "------------------"
					+ creditCardBean.getCreditcardNo());
			double balance = payment.findBalanceByCardNumber(userID,
					creditCardBean.getCreditcardNo());
			System.out.println(balance);
			double totalPrice = orderbean1.getTotalPrice();
			if (totalPrice <= balance) {
				balance = balance - totalPrice;
				creditCardBean.setBalance(balance);
				result = payment.process(creditCardBean);
				addActionMessage("Payment Successfully done.. Thank You !!! ");
			}
		}
		System.out.println(result);
		return result;
	}
	public String getAction () {
		return action;
	}
	public CreditCardBean getCreditCardBean () {
		return creditCardBean;
	}
	@Override
	public CreditCardBean getModel () {
		// TODO Auto-generated method stub
		return creditCardBean;
	}
	public void setAction (final String action) {
		this.action = action;
	}
	public void setCreditCardBean (final CreditCardBean creditCardBean) {
		this.creditCardBean = creditCardBean;
	}
}
