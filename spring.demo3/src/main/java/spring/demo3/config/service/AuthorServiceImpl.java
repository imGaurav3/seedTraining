package spring.demo3.config.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.demo3.config.dao.AuthorDao;
import spring.demo3.config.model.Author;

@Service
public class AuthorServiceImpl implements AuthorService{

	@Autowired
	private AuthorDao authorDao;
	
	@Override
	@Transactional
	public List<Author> findAll() {
		
		return authorDao.findAll();
	}

	@Override
	@Transactional
	public void create(Author a) {
		
		authorDao.create(a);
		
	}

}
