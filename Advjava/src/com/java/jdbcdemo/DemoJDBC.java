package com.java.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DemoJDBC {

	

		public static void main(String[] args) {
			Connection conn=null;
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				System.out.println("Driver Loaded...");
				String url="jdbc:oracle:thin:@LAPTOP-OP2JIB74:1521:XE";
				
				conn=DriverManager.getConnection(url,"hr","hr");
				System.out.println("Connection Done...");
				Statement stmt = conn.createStatement();
				String query = "select * from emp";
				ResultSet rs = stmt.executeQuery(query);
				while (rs.next())
					System.out.println(rs.getInt(1) + " " + rs.getString(2));

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