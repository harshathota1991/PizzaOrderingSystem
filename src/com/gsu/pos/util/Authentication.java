

package com.gsu.pos.util;


import com.gsu.pos.bean.CredentialsBean;


public interface Authentication {

	boolean authenticate (CredentialsBean credentialsBean);
	String authorize (String userId, boolean validity);
	boolean changeLoginStatus (CredentialsBean credentialsBean, int loginStatus);
}
