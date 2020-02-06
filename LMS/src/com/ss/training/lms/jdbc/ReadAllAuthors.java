package com.ss.training.lms.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadAllAuthors {
	
	public static String driver = "com.mysql.cj.jdbc.Driver";
	public static String url = "jdbc:mysql://localhost:3306/library?useSSL=false";
	public static String username = "root";
	public static String password = "root";

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//1. Register Driver.
		Class.forName(driver);
		
		//2. Connection
		Connection conn = DriverManager.getConnection(url, username, password);
		
		//3. Statement
//		String query = "select * from tbl_author";
		Statement stmt = conn.createStatement();
		
		ResultSet rs = stmt.executeQuery("select * from tbl_author");
		while(rs.next()){
			System.out.println("Author Name: " +rs.getString("authorName")
					+ " with AUthor ID: "+rs.getInt("authorId"));
		}
	}

}
