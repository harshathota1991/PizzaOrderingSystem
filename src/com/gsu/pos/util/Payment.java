

package com.gsu.pos.util;


import com.gsu.pos.bean.CreditCardBean;

public interface Payment {

	boolean findByCardNumber (String userid, String cardnumber);
	String process (CreditCardBean creditcardbean);
}
