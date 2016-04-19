

package com.gsu.pos.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.gsu.pos.bean.StoreBean;
import com.gsu.pos.util.DBUtil;
import com.gsu.pos.util.DBUtilImpl;
import com.gsu.pos.util.LogFile;


public class StoreDAOImpl implements StoreDAO {

	int ONE = 1;
	int TWO = 2;
	int THREE = 3;
	int FOUR = 4;
	int FIVE = 5;
	int SIX = 6;
	int SEVEN = 7;
	String sidseq = "";
	//StoreBean storeBean = new StoreBean();

	String res = "FAIL";
	DBUtilImpl obj=new DBUtilImpl();
	Connection connection=obj.getDBConnection();
	@Override
	public String createStore (final StoreBean storeBean) {
		try {
			
			PreparedStatement ps;
			System.out.println("inside login check");
			ps = connection
					.prepareStatement("insert into POS_TBL_pizzastore values(?,?,?,?,?,?,?)");

			ps.setString(ONE, storeBean.getStoreID());
			ps.setString(TWO, storeBean.getName());
			ps.setString(THREE, storeBean.getStreet());
			ps.setString(FOUR, storeBean.getMobileNo());
			ps.setString(FIVE, storeBean.getCity());
			ps.setString(SIX, storeBean.getState());
			ps.setString(SEVEN, storeBean.getPincode());
			int i = ps.executeUpdate();
			if (i > 0) {
				res = "SUCCESS";
			}
		}// end of try
		catch (Exception exception) {
			// TODO Auto-generated catch block
			exception.printStackTrace();
			res = "FAIL";
		}
		System.out.println("Inserted :(result is) :" + res);
		return res;
	}
	@Override
	public int deleteStore (final ArrayList<String> storeId) {
		// TODO Auto-generated method stub

		int index = 1;
		int result = 0;
		if (connection != null && storeId!=null) {
			try {

				PreparedStatement statement = connection
						.prepareStatement("delete from POS_TBL_PIZZASTORE where storeid=?");
				statement.setString(index, storeId.get(0));
				result = statement.executeUpdate();
			} catch (SQLException exception) {
				LogFile.logging(exception, "sql exception in deletestore()");
			} finally {
				try {
					connection.close();
				} catch (SQLException exception) {
					LogFile.logging(exception,
							"sql exception in finally(deletestore)");
				}
			}
		}
		return result;
	}
	@Override
	public ArrayList<StoreBean> findAll () {
		// TODO Auto-generated method stub
		int index = 1;
		ArrayList<StoreBean> storeList = new ArrayList<StoreBean>();
		StoreBean storebean = null;

		if (connection != null) {
			try {

				Statement statement = connection.createStatement();
				ResultSet resultSet = statement
						.executeQuery("select storeid,name,street,mobileno,city,state,pincode "
								+ "from POS_TBL_PIZZASTORE");
				while (resultSet.next()) {
					index = 1;
					storebean = new StoreBean();
					storebean.setStoreID(resultSet.getString(index));
					storebean.setName(resultSet.getString(++index));
					storebean.setStreet(resultSet.getString(++index));
					storebean.setMobileNo(resultSet.getString(++index));
					storebean.setCity(resultSet.getString(++index));
					storebean.setState(resultSet.getString(++index));
					storebean.setPincode(resultSet.getString(++index));
					storeList.add(storebean);
				}
			} catch (SQLException exception) {
				LogFile.logging(exception, "sql exception in findAll()");
			} finally {
				try {
					connection.close();
				} catch (SQLException exception) {
					LogFile.logging(exception,
							"sql exception in finally(findAll)");
				}
			}
		}
		return storeList;
	}
	@Override
	public ArrayList<String> findAllID () {
		ArrayList<String> idList = new ArrayList<String>();


		
		if (connection != null) {
			try {

				Statement statement = connection.createStatement();
				ResultSet resultSet = statement
						.executeQuery("select storeid from POS_TBL_PIZZASTORE");
				while (resultSet.next()) {
					idList.add(resultSet.getString(1));
				}
			} catch (SQLException exception) {
				LogFile.logging(exception, "sql exception in findAllID()");
			} finally {
				try {
					connection.close();
				} catch (SQLException exception) {
					LogFile.logging(exception,
							"sql exception in finally(findAllID)");
				}
			}
		}
		return idList;
	}
	@Override
	public StoreBean findByID (final String storeId) {
		// TODO Auto-generated method stub
		int index = 1;
		StoreBean storebean = null;

		if (connection != null) {
			try {

				Statement statement = connection.createStatement();
				ResultSet resultSet = statement
						.executeQuery("select storeid,name,street,mobileno,city,state,pincode from POS_TBL_PIZZASTORE where storeid='"+storeId+"'");
				if (resultSet.next()) {
					storebean = new StoreBean();
					storebean.setStoreID(resultSet.getString(index));
					storebean.setName(resultSet.getString(++index));
					storebean.setStreet(resultSet.getString(++index));
					storebean.setMobileNo(resultSet.getString(++index));
					storebean.setCity(resultSet.getString(++index));
					storebean.setState(resultSet.getString(++index));
					storebean.setPincode(resultSet.getString(++index));
				}
			} catch (SQLException exception) {
				LogFile.logging(exception, "sql exception in findById()");
			} finally {
				try {
					connection.close();
				} catch (SQLException exception) {
					LogFile.logging(exception,
							"sql exception in finally(findById)");
				}
			}
		}
		return storebean;
	}
	public String findID () {
		// TODO Auto-generated method stub
		try {
			
			PreparedStatement ps3;
			ResultSet rs;
			ps3 = connection
					.prepareStatement("select pos_seq_storeid.nextval from dual");
			rs = ps3.executeQuery();
			while (rs.next()) {
				sidseq = rs.getString(1);
			}
			System.out.println("Sequence id generated : " + sidseq);
		} catch (Exception exception) {
			// TODO Auto-generated catch block
			exception.printStackTrace();
			return null;
		}
		return sidseq;
	}
	@Override
	public boolean updateStore (final StoreBean storebean) {
		// TODO Auto-generated method stub
		int index = 1;
		boolean result = false;

		
		if (storebean != null && connection != null) {
			try {

				PreparedStatement statement = connection
						.prepareStatement("update POS_TBL_PIZZASTORE set name=?,street=?,"
								+ "mobileno=?,city=?,state=?,pincode=? where storeid=?");
				statement.setString(index, storebean.getName());
				statement.setString(++index, storebean.getStreet());
				statement.setString(++index, storebean.getMobileNo());
				statement.setString(++index, storebean.getCity());
				statement.setString(++index, storebean.getState());
				statement.setString(++index, storebean.getPincode());
				statement.setString(++index, storebean.getStoreID());
				int value = statement.executeUpdate();
				if (value != 0) {
					result = true;
				}
			} catch (SQLException exception) {
				LogFile.logging(exception, "sql exception in updatestore()");
			} finally {
				try {
					connection.close();
				} catch (SQLException exception) {
					LogFile.logging(exception,
							"sql exception in finally(updatestore)");
				}
			}
		}
		return result;
	}
}
