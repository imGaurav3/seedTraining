package spring.demo3.config.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.demo3.config.dao.BookDao;
import spring.demo3.config.model.Book;

@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	private BookDao bookDao;

	@Override
	@Transactional
	public List<Book> findAll() {
		
		return bookDao.findAll();
	}

	@Override
	@Transactional
	public void create(Book b) {
		
		bookDao.create(b);
		
	}

}
