package spring.demo3.config.dao;

import java.util.List;

import spring.demo3.config.model.Author;

public interface AuthorDao {
	
	public List<Author> findAll();
	
	public void create(Author a);

}
