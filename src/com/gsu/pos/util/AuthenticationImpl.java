

package com.gsu.pos.util;


import com.gsu.pos.bean.CredentialsBean;
import com.gsu.pos.dao.CredentialsDAOImpl;


public class AuthenticationImpl implements Authentication {

	@Override
	public boolean authenticate (final CredentialsBean bean) {
		boolean validity = false;
		CredentialsDAOImpl dao = new CredentialsDAOImpl();
		System.out.println(bean.getUserID());
		CredentialsBean credentials = dao.findByID(bean.getUserID());
		if (credentials != null) {
			System.out.println(bean.getPassword() + credentials.getPassword());
			if (bean.getPassword().equals(credentials.getPassword())) {
				validity = true;
			}
		}
		return validity;
	}
	@Override
	public String authorize (final String userID, final boolean validity) {
		String result = "INVALID";
		CredentialsDAOImpl dao = new CredentialsDAOImpl();
		CredentialsBean credentials = dao.findByID(userID);
		if (credentials != null) {
			result = credentials.getUserType();
		}
		return result;
	}
	@Override
	public boolean changeLoginStatus (final CredentialsBean bean,
			final int loginStatus) {
		boolean flag = false;
		System.out.println("Changes" + loginStatus);
		bean.setLoginStatus(loginStatus);
		System.out.println("Change" + loginStatus);
		CredentialsDAOImpl dao = new CredentialsDAOImpl();
		flag = dao.updateCredentials(bean);
		return flag;
	}
}
