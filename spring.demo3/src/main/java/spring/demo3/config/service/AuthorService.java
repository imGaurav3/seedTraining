package spring.demo3.config.service;

import java.util.List;

import spring.demo3.config.model.Author;

public interface AuthorService {

	public List<Author> findAll();
	
	public void create(Author a);
}
