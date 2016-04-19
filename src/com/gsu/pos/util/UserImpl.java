

package com.gsu.pos.util;


import com.gsu.pos.bean.CredentialsBean;
import com.gsu.pos.bean.ProfileBean;
import com.gsu.pos.dao.CredentialsDAOImpl;
import com.gsu.pos.dao.UserProfileDAOImpl;

public class UserImpl implements User {

	boolean log;
	@Override
	public String changePassword (final CredentialsBean credentialsBean,
			final String newPassword) {
		boolean b = false;
		String s = "FAIL";
		if(credentialsBean instanceof CredentialsBean && !newPassword.equals(""))
		{
		CredentialsDAOImpl credentialsDAOImpl = new CredentialsDAOImpl();
		b = credentialsDAOImpl.updateCredentials(credentialsBean, newPassword);
		if (b == true) {
			s = "SUCCESS";
		}
		}
		return s;
	}
	@Override
	public String login (final CredentialsBean bean) {
		String result = "INVALID";
		if (bean instanceof CredentialsBean) {
			AuthenticationImpl authentication = new AuthenticationImpl();
			boolean validity = authentication.authenticate(bean);
			if (validity) {
				result = authentication.authorize(bean.getUserID(), validity);
				if (!result.equals("INVALID")) {
					bean.setUserType(result);
					validity = authentication.changeLoginStatus(bean, 1);
					if (validity) {
						bean.setLoginStatus(1);
						result = bean.getUserType();
					}
				}
			}
			System.out.println("userimpl" + result);
		}
		return result;
	}
	@Override
	public boolean logout (final String userId) {
		// TODO Auto-generated method stub
		boolean result = false;
		if (userId != null) {
			CredentialsDAOImpl credentials = new CredentialsDAOImpl();
			CredentialsBean credentialsBean = new CredentialsBean();
			credentialsBean.setLoginStatus(0);
			credentialsBean.setUserID(userId);
			System.out.println(credentials.updateCredentials(credentialsBean)
					+ "boolean value");
			if (credentials.updateCredentials(credentialsBean)) {
				result = true;
			}
		}
		return result;
	}
	@Override
	public String register (final ProfileBean profileBean) {
		String result="FAIL";
		if(profileBean instanceof ProfileBean)
		{
		UserProfileDAOImpl userProfileObject=new UserProfileDAOImpl();
		result=userProfileObject.createUserProfileDAO(profileBean);
		}
		System.out.println("User impl res:"+result);
		
		
		return result;
	}
	
}
