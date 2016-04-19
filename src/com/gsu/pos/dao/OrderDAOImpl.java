

package com.gsu.pos.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.gsu.pos.bean.OrderBean;
import com.gsu.pos.util.DBUtil;
import com.gsu.pos.util.DBUtilImpl;
import com.gsu.pos.util.LogFile;


public class OrderDAOImpl implements OrderDAO {
	DBUtilImpl obj=new DBUtilImpl();
	Connection connection=obj.getDBConnection();
	@Override
	public String createOrder (final OrderBean orderbean) {
		// TODO Auto-generated method stub
		
		String result = "FAIL";
		try {
			System.out.println("haihjkl;' "+orderbean.getCartID());
			Statement s = connection.createStatement();
			ResultSet rs = s
					.executeQuery("Select pos_seq_orderid.nextval from dual");
			rs.next();
			orderbean.setOrderID(rs.getString(1));
			PreparedStatement ps;
			ps = connection
					.prepareStatement("insert into POS_TBL_order values(?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, orderbean.getOrderID());
			System.out.println(orderbean.getOrderID());
			ps.setString(2, orderbean.getUserID());
			System.out.println(orderbean.getUserID());
			ps.setDate(3, orderbean.getOrderDate());
			System.out.println(orderbean.getOrderDate());
			ps.setString(4, orderbean.getStoreID());
			System.out.println(orderbean.getStoreID());
			ps.setDouble(5, orderbean.getTotalPrice());
			System.out.println(orderbean.getTotalPrice());
			ps.setString(6, orderbean.getOrderStatus());
			System.out.println(orderbean.getOrderStatus());
			ps.setString(7, orderbean.getStreet());
			System.out.println(orderbean.getStreet());
			ps.setString(8, orderbean.getCity());
			System.out.println(orderbean.getCity());
			ps.setString(9, orderbean.getState());
			System.out.println(orderbean.getState());
			ps.setString(10, orderbean.getPincode());
			System.out.println(orderbean.getPincode());
			ps.setString(11, orderbean.getMobileNo());
			ps.setInt(12, orderbean.getCartID());
			System.out.println(orderbean.getMobileNo());
			if (ps.executeUpdate() > 0) {
				result = "SUCCESS";
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			// TODO: handle exception
		}
		return result;
	}
	@Override
	public int deleteOrder (final ArrayList<String> orderId) {
		// TODO Auto-generated method stub
		return 0;
	}
	public int deleteOrderByID (final String orderId) {
		// TODO Auto-generated method stub
		int result = 0;
		try {
			
			PreparedStatement ps;
			ps = connection
					.prepareStatement("delete from pos_tbl_order where orderid=? ");
			ps.setString(1, orderId);
			System.out.println("~~~~~~~~~~~~~~~~~~~~" + orderId);
			if (ps.executeUpdate() > 0) {
				result = 1;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
	@Override
	public ArrayList<OrderBean> findAll () {
		// TODO Auto-generated method stub
		ArrayList<OrderBean> arrayList = new ArrayList<OrderBean>();
		ResultSet rs;
		String result = "FAIL";
		try {
			PreparedStatement ps;
			ps = connection.prepareStatement("select * from pos_tbl_order where orderstatus not in('Delivered','Cancelled')");
			rs = ps.executeQuery();
			while (rs.next()) {
				OrderBean orderBean = new OrderBean();
				orderBean.setOrderID(rs.getString(1));
				orderBean.setUserID(rs.getString(2));
				orderBean.setOrderDate(rs.getDate(3));
				orderBean.setStoreID(rs.getString(4));
				orderBean.setTotalPrice(rs.getDouble(5));
				orderBean.setOrderStatus(rs.getString(6));
				orderBean.setStreet(rs.getString(7));
				orderBean.setCity(rs.getString(8));
				orderBean.setState(rs.getString(9));
				orderBean.setPincode(rs.getString(10));
				orderBean.setMobileNo(rs.getString(11));
				orderBean.setCartID(rs.getInt(12));
				arrayList.add(orderBean);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return arrayList;
	}
	@Override
	public OrderBean findByID (final int cartID) {
		// TODO Auto-generated method stub
		
		ArrayList<OrderBean> arrayList = new ArrayList<OrderBean>();
		ResultSet rs;
		OrderBean orderBean = new OrderBean();
		String result = "FAIL";
		try {
			PreparedStatement ps;
			ps = connection
					.prepareStatement("select * from pos_tbl_order where cartid=?");
			ps.setInt(1, cartID);
			rs = ps.executeQuery();
			while (rs.next()) {
				orderBean.setOrderID(rs.getString(1));
				orderBean.setUserID(rs.getString(2));
				orderBean.setOrderDate(rs.getDate(3));
				orderBean.setStoreID(rs.getString(4));
				orderBean.setTotalPrice(rs.getDouble(5));
				orderBean.setOrderStatus(rs.getString(6));
				orderBean.setStreet(rs.getString(7));
				orderBean.setCity(rs.getString(8));
				orderBean.setState(rs.getString(9));
				orderBean.setPincode(rs.getString(10));
				orderBean.setMobileNo(rs.getString(11));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return orderBean;
	}
	@Override
	public OrderBean findByID (final String orderId) {
		// TODO Auto-generated method stub
		return null;
	}
	public ArrayList<OrderBean> findByOrderID (final String orderId) {
		// TODO Auto-generated method stub
		
		ArrayList<OrderBean> arrayList = new ArrayList<OrderBean>();
		ResultSet rs;
		String result = "FAIL";
		try {
			PreparedStatement ps;
			ps = connection
					.prepareStatement("select orderid from pos_tbl_order where userid=?");
			ps.setString(1, orderId);
			rs = ps.executeQuery();
			while (rs.next()) {
				OrderBean orderBean = new OrderBean();
				orderBean.setOrderID(rs.getString(1));
				
				arrayList.add(orderBean);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return arrayList;
	}
	@Override
	public boolean updateOrder (final OrderBean orderbean) {
		// TODO Auto-generated method stub
		int index = 1;
		boolean result = false;

		if (orderbean != null && connection != null) {
			try {
				PreparedStatement statement = connection
						.prepareStatement("update POS_TBL_order set orderstatus=? where orderid=?");
				statement.setString(index, orderbean.getOrderStatus());
				statement.setString(++index, orderbean.getOrderID());
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
