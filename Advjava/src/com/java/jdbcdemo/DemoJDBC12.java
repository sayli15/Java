package com.java.jdbcdemo;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DemoJDBC12 {

	public static void main(String[] args) {
		Connection conn=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Loaded...");
			String url="jdbc:oracle:thin:@LAPTOP-OP2JIB74:1521:XE";
			conn=DriverManager.getConnection(url,"hr","hr");
			System.out.println("Connection Done...");
			
			
			
			
			DatabaseMetaData dbmd = conn.getMetaData();
			System.out.println(dbmd.getDatabaseProductName());
			System.out.println(dbmd.getDatabaseMajorVersion());
			System.out.println(dbmd.getDriverName());
			
			String type[] = {"TABLE"};
			ResultSet rs = dbmd.getTables(null, "JAVA", null, type);
			while(rs.next())
				System.out.println(rs.getString(3));
			
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
