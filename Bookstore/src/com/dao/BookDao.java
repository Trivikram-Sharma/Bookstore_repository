package com.dao;

import java.util.ArrayList;

import com.model.Book;

public interface BookDao {
	public String insertBookDetails(Book b);
	public boolean updateBookDetailsById(Book b);
	public boolean deleteBookDetails(int id);
	public Book getBookDetailsById(int id);
	public ArrayList<Book> getAllBookDetails();
}
