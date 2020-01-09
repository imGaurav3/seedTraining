package spring.demo3.config.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.demo3.config.model.Book;

@Repository
public class BookDaoImpl implements BookDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Book> findAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from Book a",Book.class).getResultList();
	}

	@Override
	public void create(Book b) {
		Session session = sessionFactory.getCurrentSession();
		session.save(b);
		
	}	
}
