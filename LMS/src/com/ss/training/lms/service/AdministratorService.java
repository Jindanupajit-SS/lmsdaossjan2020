/**
 * 
 */
package com.ss.training.lms.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.ss.training.lms.dao.AuthorDAO;
import com.ss.training.lms.entity.Author;
import com.ss.training.lms.entity.Book;

/**
 * @author ppradhan
 *
 */
public class AdministratorService {
	
	public ConnectionUtil connUtil = new ConnectionUtil();
	
	public void saveAuthor(Author author) throws SQLException{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			AuthorDAO adao = new AuthorDAO(conn);
			adao.addAuthor(author);
			
			for(Book b: author.getBooks()){
				adao.insertBookAuthors(author, b);
			}
			conn.commit();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();
			System.out.println("Something failed with add Author");
		} finally {
			conn.close();
		}
	}

}
