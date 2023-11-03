package com.java.jdbcdemo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DemoJDBC4 {

	public static void main(String[] args) {
		Connection conn=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Loaded...");
			
			String url="jdbc:oracle:thin:@LAPTOP-OP2JIB74:1521:XE";
			
			conn=DriverManager.getConnection(url,"hr","hr");
			System.out.println("Connection Done...");
			
			
			CallableStatement cs = conn.prepareCall("{call addEmpRec(?,?,?)}");
			cs.setInt(1, 123);
			cs.setString(2, "abc");
			cs.setDouble(3, 43590);
			cs.execute();
			System.out.println("Done");
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
