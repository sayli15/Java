package com.java.jdbcdemo;

import java.sql.DriverManager;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class DemoJDBC13 {

	public static void main(String[] args) {
try {
	
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url="jdbc:oracle:thin:@LAPTOP-OP2JIB74:1521:XE";
		RowSetFactory rp = RowSetProvider.newFactory();
		JdbcRowSet rowset=rp.createJdbcRowSet();		
	
		rowset.setUrl(url);
		rowset.setUsername("java");
		rowset.setPassword("java");
		rowset.setCommand("select*from emp18oct23");
		rowset.execute();
		while(rowset.next())
		{
			System.out.println(rowset.getInt(1)+" "+crowset.getS)
		}

}
}