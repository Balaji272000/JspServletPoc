package com.jspServletPoc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionUtil {
	
	private static String url = "jdbc:mysql://40.80.145.208:3306/painscriptdb";
	private static String driverName = "com.mysql.cj.jdbc.Driver";
	private static String username = "admin";
	private static String password = "pain";
	private static Connection con;

	public static Connection getConnection() {
		try {
			Class.forName(driverName);
			try {
				con = DriverManager.getConnection(url, username, password);
				System.out.println("database connection established....");
			} catch (SQLException ex) {
				System.out.println("Failed to create the database connection.");
			}
		} catch (ClassNotFoundException ex) {
			System.out.println("Driver not found.");
		}
		return con;
	}
}
