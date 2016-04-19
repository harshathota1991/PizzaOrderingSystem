

package com.gsu.pos.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.gsu.pos.bean.CreditCardBean;
import com.gsu.pos.util.DBUtil;
import com.gsu.pos.util.DBUtilImpl;
import com.gsu.pos.util.LogFile;


public class CreditCardDAOImpl implements CreditCardDAO {

	DBUtilImpl obj=new DBUtilImpl();
	Connection connection=obj.getDBConnection();
	
	@Override
	public String createCreditCard (final CreditCardBean creditcardbean) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int deleteCreditCard (final ArrayList<String> creditcardId) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public ArrayList<CreditCardBean> findAll () {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public CreditCardBean findByID (final String creditcardId) {
		// TODO Auto-generated method stub
		return null;
	}
	public double findID (final String userID, final String cardNo) {
		
		double balance = 0;
		
		if (connection != null) {
			try {
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement
						.executeQuery("select balance from POS_TBL_creditcard where creditcardnumber='"
								+ cardNo + "'");
				while (resultSet.next()) {
					CreditCardBean creditBean = new CreditCardBean();
					balance = resultSet.getInt(1);
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
		return balance;
	}
	@Override
	public boolean updateCreditCard (final CreditCardBean creditcardbean) {
		
		boolean bResult = false;
		
		if (connection != null) {
			try {
				PreparedStatement prepareStatement = connection
						.prepareStatement("update pos_tbl_creditcard set balance=? where creditcardnumber=?");
				prepareStatement.setDouble(1, creditcardbean.getBalance());
				prepareStatement.setString(2, creditcardbean.getCreditcardNo());
				;
				if (prepareStatement.executeUpdate() > 0) {
					bResult = true;
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
		return bResult;
	}
}
