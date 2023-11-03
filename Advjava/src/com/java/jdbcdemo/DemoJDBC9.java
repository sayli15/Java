//update record

package com.java.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DemoJDBC9 {

	public static void main(String[] args) {
		Connection conn=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Loaded...");
			String url="jdbc:oracle:thin:@LAPTOP-OP2JIB74:1521:XE";
			conn=DriverManager.getConnection(url,"hr","hr");
			System.out.println("Connection Done...");
			
			
			
			
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			ResultSet rs = stmt.executeQuery("select eno,ename,salary from emp18oct2023");
			
			while(rs.next())
				System.out.println(rs.getInt(1) + " " + rs.getString(2));
			    rs.absolute(3);
			    
			System.out.println(rs.getInt(1) + " " + rs.getString(2));

			rs.updateString(2, "TTT");
			rs.updateRow();
			System.out.println("Record updated...");
			
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
