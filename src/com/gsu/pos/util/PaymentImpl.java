

package com.gsu.pos.util;


import com.gsu.pos.bean.CreditCardBean;
import com.gsu.pos.dao.CreditCardDAOImpl;


public class PaymentImpl implements Payment {

	public double findBalanceByCardNumber (final String userid,
			final String cardnumber) {
		CreditCardDAOImpl creditCardDAO = new CreditCardDAOImpl();
		double balance = creditCardDAO.findID(userid, cardnumber);
		return balance;
	}
	@Override
	public boolean findByCardNumber (final String userid,
			final String cardnumber) {
		return false;
	}
	@Override
	public String process (final CreditCardBean creditcardbean) {
		String result = "FAIL";
		CreditCardDAOImpl creditCardDAO = new CreditCardDAOImpl();
		boolean bUpdate = creditCardDAO.updateCreditCard(creditcardbean);
		if (bUpdate == true) {
			result = "SUCCESS";
		}
		return result;
	}
}
