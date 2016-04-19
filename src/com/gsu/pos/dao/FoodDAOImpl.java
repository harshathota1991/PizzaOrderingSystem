

package com.gsu.pos.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.gsu.pos.bean.FoodBean;
import com.gsu.pos.util.DBUtilImpl;
import com.gsu.pos.util.LogFile;


public class FoodDAOImpl implements FoodDAO {

	private static final int ONE = 1;
	private static final int TWO = 2;
	private static final int THREE = 3;
	private static final int FOUR = 4;
	private static final int FIVE = 5;
	private static final int SIX = 6;
	Connection conn;
	String fidseq;
	String res;
	@Override
	public String createFood (final FoodBean foodBean) {
		try {
			DBUtilImpl DBUtilImpl = new DBUtilImpl();
			conn = DBUtilImpl.getDBConnection("driver");
			System.out.println(foodBean.getFoodID());
			PreparedStatement ps;
			System.out.println("inside login check");
			ps = conn
					.prepareStatement("insert into POS_TBL_food values(?,?,?,?,?,?)");
			ps.setString(ONE, foodBean.getFoodID());
			ps.setString(FOUR, foodBean.getName());
			ps.setString(FIVE, foodBean.getType());
			ps.setString(SIX, foodBean.getFoodSize());
			ps.setInt(TWO, foodBean.getQuantity());
			ps.setDouble(THREE, foodBean.getPrice());
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
	public int deleteFood (final ArrayList<String> foodId) {
		// TODO Auto-generated method stub
		int index = 1;
		int result = 0;
		Connection connection = null;
		try {
			connection = DBUtilImpl.getDBConnection("drivertype4");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (connection != null && foodId != null) {
			try {
				PreparedStatement statement = connection
						.prepareStatement("delete from POS_TBL_FOOD where foodid=?");
				statement.setString(index, foodId.get(0));
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
	public ArrayList<FoodBean> findAll () {
		// TODO Auto-generated method stub
		int index = 1;
		ArrayList<FoodBean> foodList = new ArrayList<FoodBean>();
		FoodBean foodbean = null;
		Connection connection = null;
		try {
			connection = DBUtilImpl.getDBConnection("drivertype4");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (connection != null) {
			try {
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement
						.executeQuery("select foodID,name,type,foodsize,quantity,price from POS_TBL_FOOD");
				while (resultSet.next()) {
					index = 1;
					foodbean = new FoodBean();
					foodbean.setFoodID(resultSet.getString(index));
					foodbean.setName(resultSet.getString(++index));
					foodbean.setType(resultSet.getString(++index));
					foodbean.setFoodSize(resultSet.getString(++index));
					foodbean.setQuantity(resultSet.getInt(++index));
					foodbean.setPrice(resultSet.getDouble(++index));
					foodList.add(foodbean);
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
		return foodList;
	}
	public ArrayList<FoodBean> findAllByCartID (final int cartID) {
		// TODO Auto-generated method stub
		int index = 1;
		ArrayList<FoodBean> foodList = new ArrayList<FoodBean>();
		FoodBean foodbean = null;
		System.out.println("ssssssssssss------------");
		Connection connection = null;
		try {
			connection = DBUtilImpl.getDBConnection("drivertype4");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (connection != null) {
			try {
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement
						.executeQuery("select foodID,name,type,foodsize,quantity,price from POS_TBL_FOOD where "
								+ "foodid not in(select foodid from pos_tbl_cart where serialno='"
								+ cartID + "')");
				System.out.println("Query successful");
				while (resultSet.next()) {
					index = 1;
					foodbean = new FoodBean();
					foodbean.setFoodID(resultSet.getString(index));
					foodbean.setName(resultSet.getString(++index));
					foodbean.setType(resultSet.getString(++index));
					foodbean.setFoodSize(resultSet.getString(++index));
					foodbean.setQuantity(resultSet.getInt(++index));
					foodbean.setPrice(resultSet.getDouble(++index));
					foodList.add(foodbean);
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
		return foodList;
	}
	@Override
	public ArrayList<String> findAllID () {
		ArrayList<String> idList = new ArrayList<String>();
		Connection connection = null;
		try {
			connection = DBUtilImpl.getDBConnection("drivertype4");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (connection != null) {
			try {
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement
						.executeQuery("select foodid from POS_TBL_FOOD");
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
	public FoodBean findByID (final String foodId) {
		// TODO Auto-generated method stub
		int index = 1;
		FoodBean foodbean = null;
		System.out.println("find by id" + foodId);
		Connection connection = null;
		try {
			connection = DBUtilImpl.getDBConnection("drivertype4");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (connection != null) {
			try {
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement
						.executeQuery("select foodID,name,type,foodsize,quantity,price from POS_TBL_FOOD where foodid='"
								+ foodId + "'");
				while (resultSet.next()) {
					index = 1;
					foodbean = new FoodBean();
					foodbean.setFoodID(resultSet.getString(index));
					foodbean.setName(resultSet.getString(++index));
					foodbean.setType(resultSet.getString(++index));
					foodbean.setFoodSize(resultSet.getString(++index));
					foodbean.setQuantity(resultSet.getInt(++index));
					foodbean.setPrice(resultSet.getDouble(++index));
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
		return foodbean;
	}
	public String findID () {
		// TODO Auto-generated method stub
		try {
			DBUtilImpl obj = new DBUtilImpl();
			Connection con = obj.getDBConnection("driver");
			PreparedStatement ps3;
			ResultSet rs;
			ps3 = con
					.prepareStatement("select pos_seq_foodid.nextval from dual");
			rs = ps3.executeQuery();
			while (rs.next()) {
				fidseq = rs.getString(1);
			}
			System.out.println("Sequence id generated : " + fidseq);
		} catch (Exception exception) {
			// TODO Auto-generated catch block
			exception.printStackTrace();
			return null;
		}
		return fidseq;
	}
	@Override
	public boolean updateFood (final FoodBean foodbean) {
		// TODO Auto-generated method stub
		int index = 1;
		boolean result = false;
		Connection connection = null;
		try {
			connection = DBUtilImpl.getDBConnection("drivertype4");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (foodbean != null && connection != null) {
			try {
				PreparedStatement statement = connection
						.prepareStatement("update POS_TBL_FOOD set name=?,type=?,foodsize=?,quantity=?,price=? where foodid=?");
				statement.setString(index, foodbean.getName());
				statement.setString(++index, foodbean.getType());
				statement.setString(++index, foodbean.getFoodSize());
				statement.setInt(++index, foodbean.getQuantity());
				statement.setDouble(++index, foodbean.getPrice());
				statement.setString(++index, foodbean.getFoodID());
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
