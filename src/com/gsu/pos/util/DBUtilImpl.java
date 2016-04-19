package com.gsu.pos.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.gsu.pos.util.DBUtil;

public class DBUtilImpl implements DBUtil {

	@Override
	public Connection getDBConnection() {
		// TODO Auto-generated method stub
		Connection con=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
			System.out.println("inside DBUtilIMPL");
		} catch (ClassNotFoundException cnfe) {
			// TODO Auto-generated catch block
			cnfe.printStackTrace();
		} catch (SQLException sqle) {
			// TODO Auto-generated catch block
			sqle.printStackTrace();
		}
		return con;
	}
	public static Connection getDBConnection(String driver) {
		// TODO Auto-generated method stub
		Connection con=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
			System.out.println("inside DBUtilIMPL");
		} catch (ClassNotFoundException cnfe) {
			// TODO Auto-generated catch block
			cnfe.printStackTrace();
		} catch (SQLException sqle) {
			// TODO Auto-generated catch block
			sqle.printStackTrace();
		}
		return con;
	}

}
