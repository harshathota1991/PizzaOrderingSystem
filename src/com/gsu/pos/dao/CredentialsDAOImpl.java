

package com.gsu.pos.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.gsu.pos.bean.CredentialsBean;
import com.gsu.pos.util.DBUtil;
import com.gsu.pos.util.DBUtilImpl;



public class CredentialsDAOImpl implements CredentialsDAO {

	private String result = "FAIL";
	private String userID;
	private int ONE = 1;
	private int TWO = 2;
	private int THREE = 3;
	private int FOUR = 4;
	DBUtilImpl obj=new DBUtilImpl();
	Connection connection=obj.getDBConnection();
	@Override
	public String createCredentials (final CredentialsBean credentialsBean) {
		try {
			// CredentialsBean credentialsBean=new CredentialsBean();

			Statement s = connection.createStatement();
			PreparedStatement ps = connection
					.prepareStatement("insert into pos_tbl_user_credentials values (?,?,?,?)");
			ps.setString(ONE, credentialsBean.getUserID());
			ps.setString(TWO, credentialsBean.getPassword());
			ps.setString(THREE, credentialsBean.getUserType());
			ps.setInt(FOUR, credentialsBean.getLoginStatus());
			if (ps.executeUpdate() > 0) {
				result = "SUCCESS";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
	@Override
	public int deleteCredentials (final ArrayList<String> userId) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public ArrayList<CredentialsBean> findAll () {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public CredentialsBean findByID (final String userID) {
		CredentialsBean credentialsBean = new CredentialsBean();
		try {
			System.out.println(userID);
			// Statement s=conn.createStatement();
			System.out.println(userID);
			PreparedStatement ps = connection
					.prepareStatement("select * from pos_tbl_user_credentials where userid=?");
			ps.setString(1, userID);
			ResultSet rs = ps.executeQuery();
			System.out.println(rs.next());
			credentialsBean.setUserID(rs.getString(1));
			credentialsBean.setPassword(rs.getString(3));
			credentialsBean.setUserType(rs.getString(4));
			credentialsBean.setLoginStatus(rs.getInt(2));
			System.out.println(credentialsBean.getUserID());
		} catch (Exception exception) {
		}
		return credentialsBean;
	}
	public String findID () {
		Connection conn;
		try {
			Statement s = connection.createStatement();
			ResultSet rs = s
					.executeQuery("select pos_seq_userid.nextval from dual");
			while (rs.next()) {
				userID = rs.getString(1);
				System.out.println(userID);
			}
		} catch (Exception exception) {
			// TODO: handle exception
		}
		return userID;
	}
	@Override
	public boolean updateCredentials (final CredentialsBean bean) {
		// CredentialsBean credentialsBean=new CredentialsBean();
		boolean b = false;
		try {
			PreparedStatement ps = connection
					.prepareStatement("update pos_tbl_user_credentials set LoginStatus=? where userID=?");
			ps.setInt(ONE, bean.getLoginStatus());
			ps.setString(TWO, bean.getUserID());
			if (ps.executeUpdate() > 0) {
				b = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return b;
	}
	public boolean updateCredentials (final CredentialsBean bean,
			final String changePassword) {
		boolean b = false;
		try {
			PreparedStatement ps = connection
					.prepareStatement("update pos_tbl_user_credentials set password=? where userID=?");
			ps.setString(ONE, changePassword);
			ps.setString(TWO, bean.getUserID());
			if (ps.executeUpdate() > 0) {
				b = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("dao" + b);
		return b;
	}
}
