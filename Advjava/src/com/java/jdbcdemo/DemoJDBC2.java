//Insert
package com.java.jdbcdemo;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DemoJDBC2 {

	public static void main(String[] args) {
		Connection conn=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Loaded...");
			
			String url="jdbc:oracle:thin:@LAPTOP-OP2JIB74:1521:XE";
			
			conn=DriverManager.getConnection(url,"hr","hr");
			System.out.println("Connection Done...");
			Statement stmt = conn.createStatement();
			String query = "insert into emp18oct2023 values(112,'PQR',12345.25)";
			int count=stmt.executeUpdate(query);
			if(count>0)
				System.out.println("Record Inserted..");
			else
				System.out.println("No Record Inserted");
			
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
