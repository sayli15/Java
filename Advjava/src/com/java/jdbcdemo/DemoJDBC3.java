package com.java.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DemoJDBC3 {

	public static void main(String[] args) {
		Connection conn=null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Loaded...");
			String url="jdbc:oracle:thin:@LAPTOP-OP2JIB74:1521:XE";
			
			conn=DriverManager.getConnection(url,"hr","hr");
			System.out.println("Connection Done...");
			
			
			Statement stmt = conn.createStatement();
//			Scanner sc = new Scanner(System.in);
//			System.out.println("Enter the query: ");
			String query = "update emp18oct2023 set salary=? where eno =?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setDouble(1, 33333.33);
			ps.setInt(2, 112);
			
			boolean result = ps.execute();
			if(!result) 
				System.out.println("record updated ");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
