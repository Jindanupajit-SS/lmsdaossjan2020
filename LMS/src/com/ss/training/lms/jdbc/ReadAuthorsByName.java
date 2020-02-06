package com.ss.training.lms.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ReadAuthorsByName {
	
	public static String driver = "com.mysql.cj.jdbc.Driver";
	public static String url = "jdbc:mysql://localhost:3306/library?useSSL=false";
	public static String username = "root";
	public static String password = "root";

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//1. Register Driver.
		Class.forName(driver);
		
		//2. Connection
		Connection conn = DriverManager.getConnection(url, username, password);
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter author name to search: ");
		String authorName = scan.nextLine();
		//3. Statement
//		String query = "select * from tbl_author";
		PreparedStatement pstmt = conn.prepareStatement("select * from tbl_author where authorName = ? ");
		pstmt.setString(1, authorName);
		
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			System.out.println("Author Name: " +rs.getString("authorName")
					+ " with AUthor ID: "+rs.getInt("authorId"));
		}
	}

}
