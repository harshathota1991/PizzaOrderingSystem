


package com.gsu.pos.dao;



import com.gsu.pos.bean.CreditCardBean;

import java.util.ArrayList;




public interface CreditCardDAO {

	String createCreditCard (CreditCardBean creditcardbean);
	int deleteCreditCard (ArrayList<String> creditcardId);
	ArrayList<CreditCardBean> findAll ();
	CreditCardBean findByID (String creditcardId);
	boolean updateCreditCard (CreditCardBean creditcardbean);
}
