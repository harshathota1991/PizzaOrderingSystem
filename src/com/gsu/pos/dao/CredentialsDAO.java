


package com.gsu.pos.dao;




import com.gsu.pos.bean.CredentialsBean;

import java.util.ArrayList;



public interface CredentialsDAO {

	String createCredentials (CredentialsBean credentialsbean);
	int deleteCredentials (ArrayList<String> userId);
	ArrayList<CredentialsBean> findAll ();
	CredentialsBean findByID (String userId);
	boolean updateCredentials (CredentialsBean credentialsbean);
}
