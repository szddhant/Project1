package com.util;

import java.sql.*;


public class DbConnectionPro {
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection("jdbc:sqlserver://localhost:61191;DatabaseName=JSP_PROJECT;trustServerCertificate=true;","sa","root");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
//	public static void main(String[] args) {
//		Connection con = null;
//		con = getConnection();
//		if(con!=null) {
//			System.out.println("Connection Found");
//		}
//		else {
//			System.out.println("Connection not found");
//		}
//	}
}
