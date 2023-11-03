package com.java.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DemoJDBC6 {

	public static void main(String[] args) {
		Connection conn=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Loaded...");
			String url="jdbc:oracle:thin:@LAPTOP-OP2JIB74:1521:XE";
			conn=DriverManager.getConnection(url,"hr","hr");
			System.out.println("Connection Done...");
			conn.setAutoCommit(false);
			
			
			Statement stmt = conn.createStatement();
			stmt.addBatch("insert into emp18oct2023 values(125,'abd',2345.6)");
			stmt.addBatch("insert into emp18oct2023 values(126,'bhg',6542.7)");
			stmt.addBatch("insert into emp18oct2023 values(127,'nty',9876.2)");
			stmt.addBatch("insert into emp18oct2023 values(128,'nbt',10096.5)");
			
			int []result = stmt.executeBatch();
			
		} catch (ClassNotFoundException | SQLException e) {
			try {
				conn.rollback();
				System.out.println("Not done...");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		try {
			conn.commit();
			System.out.println("Done...");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {

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
