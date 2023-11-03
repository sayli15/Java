package com.java.jdbcdemo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class DemoJDBC5 {

	public static void main(String[] args) {
		Connection conn=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Loaded...");
			
			String url="jdbc:oracle:thin:@LAPTOP-OP2JIB74:1521:XE";
			
			conn=DriverManager.getConnection(url,"hr","hr");
			System.out.println("Connection Done...");
			
			
			CallableStatement cs = conn.prepareCall("{?=call FindSal(?)}");
			cs.registerOutParameter(1, Types.DOUBLE);
			cs.setInt(2,101);
			cs.execute();
			System.out.println(cs.getDouble(1));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
