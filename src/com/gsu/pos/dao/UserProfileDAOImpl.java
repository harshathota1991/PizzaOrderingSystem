package com.gsu.pos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;




import com.gsu.pos.bean.ProfileBean;
import com.gsu.pos.util.DBUtil;
import com.gsu.pos.util.DBUtilImpl;

public class UserProfileDAOImpl implements UserProfileDAO{
	private static final int ONE=1;
	private static final int TWO=2;
	private static final int THREE=3;
	private static final int FOUR=4;
	private static final int FIVE=5;
	private static final int SIX=6;
	private static final int SEVEN=7;
	private static final int EIGHT=8;
	private static final int NINE=9;
	private static final int TEN=10;
	private static final int ELEVEN=11;
	private static final int TWELVE=12;
	DBUtilImpl obj=new DBUtilImpl();
	Connection connection=obj.getDBConnection();
public String createUserProfileDAO(ProfileBean profileBean)
	
	{
		PreparedStatement ps,ps1;
		String result="FAIL";
		try{
			if(profileBean!=null)
			{
			ps=connection.prepareStatement("insert into POS_TBL_User_Profile values(?,?,?,?,?,?,?,?,?,?,?,?)" );
				
					String str;
					DateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
					str=formatter.format(profileBean.getDateOfBirth());
					java.sql.Date date=java.sql.Date.valueOf(str);
					
					System.out.println("User profile table"+profileBean.getFirstName());
					
					String uidseq=findID(profileBean.getFirstName());
					System.out.println("hi"+profileBean.getLocation());
					
					ps.setString(ONE,profileBean.getLocation());
					System.out.println("Loc added "+profileBean.getLocation());
					ps.setString(TWO,uidseq);
					profileBean.setUserID(uidseq);
					System.out.println("uid added "+uidseq);
					ps.setString(THREE,profileBean.getState());
					System.out.println("state added "+profileBean.getState());
					ps.setString(FOUR,profileBean.getPincode());
					System.out.println("pin added "+profileBean.getPincode());
					ps.setString(FIVE,profileBean.getMobileNo());
					System.out.println("mob added "+profileBean.getMobileNo());
					ps.setString(SIX,profileBean.getEmailID());
					System.out.println("email id added "+profileBean.getEmailID());
					ps.setString(SEVEN,profileBean.getCity());
					System.out.println("city added "+profileBean.getCity());
					ps.setString(EIGHT,profileBean.getFirstName());
					System.out.println("fname added "+profileBean.getFirstName());
					ps.setString(NINE,profileBean.getLastName());
					System.out.println("Lname added "+profileBean.getLastName());
					ps.setDate(TEN,date);
					System.out.println("Date added ");
					ps.setString(ELEVEN,profileBean.getGender());
					System.out.println("gender added "+profileBean.getGender());
					ps.setString(TWELVE,profileBean.getStreet());
					System.out.println("street added "+profileBean.getStreet());
					System.out.println("Before update");
					//ps.executeUpdate();
					System.out.println("Record inserted in UserProfile table");
						
						ps1=connection.prepareStatement("insert into POS_TBL_User_Credentials values(?,?,?,?)" );
						ps1.setString(ONE,uidseq);
						ps1.setInt(TWO,0);
						ps1.setString(THREE,profileBean.getPassword());
						ps1.setString( FOUR,"C");
						ps1.executeUpdate();
						ps.executeUpdate();
						System.out.println("Record inserted in User_Credentials table");
									
					result= uidseq;		
				
			}
			
				}//end of try
		           catch (SQLException sqle) {
			// TODO Auto-generated catch block
			sqle.printStackTrace();
			
		
		}
		
		return result;
			
	}



String findID(String str)
{
	PreparedStatement ps3;
	ResultSet rs;
	String uidseq="";
	try {
		ps3=connection.prepareStatement("select pos_seq_userid.nextval from dual");
		rs=ps3.executeQuery();
		while(rs.next())
		{
			uidseq=rs.getString(1);
		}
		str=str.substring(0,2).toUpperCase();
		System.out.println(str);
		uidseq=str+uidseq;
		return uidseq;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
}

@Override
public int deleteUserProfileDAO(ArrayList<String> str) {
	// TODO Auto-generated method stub
	return 0;
}

@Override
public boolean updateUserProfileDAO(ProfileBean profileBean) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public ProfileBean findByID (final String userId) {
	// TODO Auto-generated method stub
	ProfileBean profileBean = new ProfileBean();
	ResultSet resultSet;
	try {
		// ProfileBean profileBean=new ProfileBean();
		DBUtilImpl dbUtil = new DBUtilImpl();
		connection = dbUtil.getDBConnection("driver");
		System.out.println(userId);
		PreparedStatement ps = connection
				.prepareStatement("select street,city,state,pincode,mobileno from pos_tbl_user_profile where userid=?");
		ps.setString(1, userId);
		resultSet = ps.executeQuery();
		resultSet.next();
		profileBean.setStreet(resultSet.getString(1));
		profileBean.setCity(resultSet.getString(2));
		profileBean.setState(resultSet.getString(3));
		profileBean.setPincode(resultSet.getString(4));
		profileBean.setMobileNo(resultSet.getString(5));
		System.out.println("inside asdfnasjfd" + resultSet.getString(5));
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println(e.toString());
	}
	return profileBean;
}
@Override
public ArrayList<ProfileBean> findAll() {
	// TODO Auto-generated method stub
	return null;
}	


}
