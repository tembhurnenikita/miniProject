package com.cybage.util;

import java.sql.*;

import org.apache.commons.dbcp2.BasicDataSource;

public class DbUtil {

	private static String className = "com.mysql.jdbc.Driver";
	private static String dbUrl = "jdbc:mysql://127.0.0.1:3306/java-minor";
	private static String dbUser = "root";
	private static String dbPassword = "cybage@123";
	private static Connection connect = null;
	
	////without connection pool
	public static Connection getCon() throws Exception{
		System.out.println("This is get con");
		Class.forName(className).newInstance();
		BasicDataSource bs = new BasicDataSource();
		bs.setDriverClassName(className);
		bs.setUrl(dbUrl);
		bs.setUsername(dbUser);
		bs.setPassword(dbPassword);
		bs.setMinIdle(5);
		bs.setMaxIdle(10);
//		connect = DriverManager.getConnection("jdbc:mysql://localhost/java-minor?user=root&password=cybage@123");
		
		return bs.getConnection();
	}
}