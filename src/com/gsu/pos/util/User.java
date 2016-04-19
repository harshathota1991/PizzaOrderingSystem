

package com.gsu.pos.util;


import com.gsu.pos.bean.CredentialsBean;
import com.gsu.pos.bean.ProfileBean;

public interface User {
	String changePassword (CredentialsBean credentialsBean, String newPassword);
	
	String login (CredentialsBean credentialsBean);
	boolean logout (String userId);
	String register (ProfileBean profileBean);
}
