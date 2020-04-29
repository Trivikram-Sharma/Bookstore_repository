package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.model.Book;

public class BookDaoImpl implements BookDao{
	
	String url = "jdbc:mysql://localhost:3306/Bookstore";
	String user = "root";
	String password = "root";
	public Connection getDbConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, user, password);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	@Override
	public String insertBookDetails(Book b) {
		// TODO Auto-generated method stub
		Connection connection = getDbConnection();
		String sql = "insert into book(title,author,price) values(?,?,?)";
		String status = "Data not inserted";
		try {
			PreparedStatement psmt = connection.prepareStatement(sql);
			psmt.setString(1, b.getTitle());
			psmt.setString(2, b.getAuthor());
			psmt.setFloat(3, b.getPrice());
			int rows = psmt.executeUpdate();
			if(rows>0) {
				System.out.println("Rows affected ->"+rows);
				status = "Data Inserted Successfully";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return status;
		
	}

	@Override
	public boolean updateBookDetailsById(Book b) {
		// TODO Auto-generated method stub
		Connection connection = getDbConnection();
		String sql = "update book set title=?, author=?,price=? where book_id=?";
		PreparedStatement psmt;
		try {
			psmt = connection.prepareStatement(sql);
			psmt.setString(1,b.getTitle());
			psmt.setString(2, b.getAuthor());
			psmt.setFloat(3, b.getPrice());
			psmt.setInt(4, b.getId());
			
			int rows = psmt.executeUpdate();
			if(rows>0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return false;
	}

	@Override
	public boolean deleteBookDetails(int id) {
		// TODO Auto-generated method stub
		Connection connection = getDbConnection();
		String sql = "delete from book where book_id=?";
		try {
			PreparedStatement psmt = connection.prepareStatement(sql);
			psmt.setInt(1, id);
			int rows = psmt.executeUpdate();
			if(rows>0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return false;
	}

	@Override
	public Book getBookDetailsById(int id) {
		// TODO Auto-generated method stub
		Connection connection = getDbConnection();
		Book b = null;
		String sql = "select * from book where book_id=?";
		try {
			PreparedStatement psmt = connection.prepareStatement(sql);
			psmt.setInt(1, id);
			ResultSet rs = psmt.executeQuery();
			while(rs.next()) {
				int book_id = rs.getInt("book_id");
				String title = rs.getString("title");
				String author = rs.getString("author");
				float price = rs.getFloat("price");
				b = new Book(book_id, title, author, price);
				System.out.println(b);
			}
			return b;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return b;
	}

	@Override
	public ArrayList<Book> getAllBookDetails() {
		// TODO Auto-generated method stub
		ArrayList<Book> booklist = new ArrayList<Book>();
		Connection connection = getDbConnection();
		String sql = "select * from book";
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				int id = rs.getInt("book_id");
				String title = rs.getString("title");
				String author = rs.getString("author");
				float price = rs.getFloat("price");
				Book b = new Book(id, title, author, price);
				booklist.add(b);
			}
			return booklist;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return booklist;
		
	}

}
