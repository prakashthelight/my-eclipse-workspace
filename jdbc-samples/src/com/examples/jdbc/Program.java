package com.examples.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program {
	
	private static final String USERNAME = "root";
	private static final String PASSWORD = "pass@word1";
	private static final String CONNECTION_STRING = "jdbc:mysql://localhost/sample?useSSL=false";

	public static void main(String[] args) throws SQLException {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {			
			conn = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD);
			System.out.println("Connected!");
			
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			rs = stmt.executeQuery("SELECT * FROM CUSTOMERS");
			
			while (rs.next()) {				
				System.out.println(rs.getString(1) + " " + rs.getString(2));
			}
			
		} catch (SQLException e) {
			System.err.println(e);
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
	}
}
