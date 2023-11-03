package com.java.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class DemoJDBC11 {

	public static void main(String[] args) {
		Connection conn=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Loaded...");
			String url="jdbc:oracle:thin:@LAPTOP-OP2JIB74:1521:XE";
			conn=DriverManager.getConnection(url,"hr","hr");
			System.out.println("Connection Done...");
			
			
			
			
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery("select * from emp18oct2023");
			ResultSetMetaData rsmd = rs.getMetaData();
			System.out.println("total columns " + rsmd.getColumnCount());
			
			for(int i=1;i<=rsmd.getColumnCount();i++) {
				System.out.println(rsmd.getColumnName(i));
				System.out.println(" " + rsmd.getColumnTypeName(i));
			}
			
			
			
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
