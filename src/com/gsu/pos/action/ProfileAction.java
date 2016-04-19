package com.gsu.pos.action;


import com.gsu.pos.bean.CredentialsBean;
import com.gsu.pos.bean.ProfileBean;
import com.gsu.pos.util.UserImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ProfileAction extends ActionSupport implements ModelDriven<ProfileBean>{

	private static final long serialVersionUID = 2341036297236575568L;
	
	private ProfileBean profileBean = new ProfileBean();
	

public ProfileBean getProfileBean() {
		return profileBean;
	}

	public void setProfileBean(ProfileBean profileBean) {
		this.profileBean = profileBean;
	}

	@Override
	public ProfileBean getModel() {
		// TODO Auto-generated method stub
		return profileBean;
	}

public String execute()
{
	System.out.println("inside profileaction");
	System.out.println("In execute: "+profileBean.getFirstName());
	UserImpl userObject=new UserImpl();
	String result="FAIL";
	result=userObject.register(profileBean);
	System.out.println("result:"+result);
	//CredentialsBean credentialsBean = new CredentialsBean();
	addActionMessage("Your user id is : "+result);
	if(result.length()==6)
	{
	 result="SUCCESS";
	}
	return result;
}






}
