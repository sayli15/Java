package com.java.jdbcdemo;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DemoJDBC1 {

	public static void main(String[] args) {
			Connection conn=null;
			
				try {
					conn = DBUtil.getConn();
					
					Statement stmt = conn.createStatement();
					Scanner sc = new Scanner(System.in);
					System.out.println("Enter the query: ");
					String query = sc.nextLine();
					
					boolean result = stmt.execute(query);
					if(result) {
						ResultSet rs = stmt.getResultSet();
						while (rs.next())
							System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + 
						rs.getDouble(3));
					}
					else {
						int count = stmt.getUpdateCount();
						if(count>0) {
							System.out.println(count + " Record updated");
						}
						else {
							System.out.println(count + " Record updated");
						}
					}
				}catch (SQLException e) {
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


