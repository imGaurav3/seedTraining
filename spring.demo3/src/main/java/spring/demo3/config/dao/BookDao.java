package spring.demo3.config.dao;

import java.util.List;

import spring.demo3.config.model.Book;

public interface BookDao {

	public List<Book> findAll();
	
	public void create(Book b);
}
