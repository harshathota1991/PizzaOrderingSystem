 package com.gsu.pos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.gsu.pos.bean.CartBean;
import com.gsu.pos.bean.StoreBean;
import com.gsu.pos.util.DBUtil;
import com.gsu.pos.util.DBUtilImpl;
import com.gsu.pos.util.LogFile;


public class CartDAOImpl implements CartDAO {
	String						fidseq;
	String						res;
	private int index=1;
	int cartSeq;
	boolean result;
	DBUtilImpl obj=new DBUtilImpl();
	Connection connection=obj.getDBConnection();
	@Override
	public String createCart (final CartBean cartbean) {
		// TODO Auto-generated method stub
		try {

			java.util.Date date = new java.util.Date();
			long dateLong = date.getTime();

System.out.println("\n\n\n"+cartbean.getType()+"\n\n"+cartbean.getCost());
			PreparedStatement ps;
			System.out.println("inside login check");
			
			System.out.println(cartbean.getUserID()+"~~~~"+ cartbean.getQuantity()+"---------"+cartbean.getOrderDate());
			
			ps = connection
					.prepareStatement("insert into POS_TBL_cart values(?,?,?,?,?,?,?)");
			ps.setInt(1, cartbean.getCartID());
			ps.setString(2, cartbean.getUserID());
			ps.setString(3,cartbean.getFoodID().trim());
			ps.setString(4,cartbean.getType());
			ps.setInt(5,cartbean.getQuantity());
			ps.setDouble(6,cartbean.getCost());
			ps.setDate(7, new java.sql.Date(dateLong));
			//System.out.println(new java.sql.Date(dateLong));
			//ps.setString(7, "default");
			int i = ps.executeUpdate();
			System.out.println("i value ~~~~~"+i);
			if (i > 0) {
				res = "SUCCESS";
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
			System.out.println("<>>>>>>><<<<<<<>>>>>><<<<<<>>>>>>>>>fail in sql");
			res = "FAIL";
		}

		return res;
	}
	@Override
	public int deleteCart (final ArrayList<String> cartId) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public ArrayList<CartBean> findAll () {
		// TODO Auto-generated method stub
	return null;
	}
	@Override
	public ArrayList<CartBean> findAll (final int cartID) {

		ArrayList<CartBean> arrayList = new ArrayList<CartBean>();
		//CartBean cartBean=new CartBean();
System.out.println("cart id in dao classs........."+cartID);
				if (connection != null) {
					try {

						Statement statement = connection.createStatement();
						ResultSet resultSet = statement
								.executeQuery("select * from POS_TBL_cart where serialno='"+cartID+"'");
						while (resultSet.next()) {
							CartBean cartBean=new CartBean();
							cartBean.setCartID(resultSet.getInt(1));
							cartBean.setUserID(resultSet.getString(2));
							cartBean.setFoodID(resultSet.getString(3));
							cartBean.setType(resultSet.getString(4));
							cartBean.setQuantity(resultSet.getInt(5));
							cartBean.setCost(resultSet.getInt(6));
							cartBean.setOrderDate(resultSet.getDate(7));
							arrayList.add(cartBean);
							System.out.println("--------------------");
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
				System.out.println(arrayList.size()+"size in dao"+cartSeq);
				return arrayList;
	}
	@Override
	public CartBean findByID (final String cartId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<String> findCity () {
		// TODO Auto-generated method stub
		int index = 1;
		ArrayList<String> storeList = new ArrayList<String>();
		StoreBean storebean = null;

		
		if (connection != null) {
			try {

				Statement statement = connection.createStatement();
				ResultSet resultSet = statement
						.executeQuery("select DISTINCT city  from POS_TBL_PIZZASTORE");
				while (resultSet.next()) {

					storebean = new StoreBean();

					storebean.setCity(resultSet.getString(1));
					storeList.add(storebean.getCity());
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
	public ArrayList<StoreBean> findStore (final String city) {
		// TODO Auto-generated method stub
		int index = 1;
		ArrayList<StoreBean> storeList = new ArrayList<StoreBean>();
		StoreBean storebean = null;

		
		if (connection != null) {
			try {

				Statement statement = connection.createStatement();
				ResultSet resultSet = statement
						.executeQuery("select storeid,name,street,mobileno from POS_TBL_PIZZASTORE where city='"+city+"'");
				while (resultSet.next()) {
					index = 1;
					storebean = new StoreBean();

					storebean.setStoreID(resultSet.getString(index));
					storebean.setName(resultSet.getString(++index));
					storebean.setStreet(resultSet.getString(++index));
					storebean.setMobileNo(resultSet.getString(++index));
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
	public int getSerialNum(){

		try {
			PreparedStatement ps3;
			ResultSet rs;
			ps3 = connection
					.prepareStatement("select pos_seq_cartID.nextval from dual");
			rs = ps3.executeQuery();
			while (rs.next()) {
				cartSeq = rs.getInt(1);
			}
			System.out.println("Sequence id generated : " + cartSeq);
		} catch (Exception exception) {
			// TODO Auto-generated catch block
			exception.printStackTrace();

		}
		return cartSeq;



	}

	@Override
	public boolean updateCart (final CartBean cartbean) {
		// TODO Auto-generated method stub

		try {


System.out.println("\n\n "+cartbean.getCartID()+"\n\n"+cartbean.getFoodID()+"\n\n"+cartbean.getQuantity()+"\n\n"+cartbean.getCost());
//System.out.println("\n\n\n"+cartbean.getType()+"\n\n"+cartbean.getCost());
			PreparedStatement ps;
			//System.out.println("inside login check");
			//dat=DateConverter.convertToSql(dt);
			//System.out.println(cartbean.getFoodID()+"~~~~"+ cartbean.getQuantity()+"---------");
			//System.out.println(new java.sql.Date(dateLong));
			ps = connection
					.prepareStatement("update POS_TBL_cart set quantity=?,cost=? where foodId=? and serialno=?");
			ps.setInt(1, cartbean.getQuantity());
			ps.setDouble(2, cartbean.getCost());
			ps.setString(3,cartbean.getFoodID().trim());
			ps.setInt(4,cartbean.getCartID());

			//System.out.println("********///////--------"+cartbean.getCost());
			//System.out.println(new java.sql.Date(dateLong));
			//ps.setString(7, "default");
			int i = ps.executeUpdate();
			System.out.println("i value ~~~~~"+i);
			if (i != 0) {
				result=true;
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
			//System.out.println("<>>>>>>><<<<<<<>>>>>><<<<<<>>>>>>>>>fail in sql");

		}

	return result;
	}

}
