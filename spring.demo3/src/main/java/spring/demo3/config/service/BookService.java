package spring.demo3.config.service;

import java.util.List;

import spring.demo3.config.model.Book;

public interface BookService {

	public List<Book> findAll();
	public void create(Book b);
	
}
