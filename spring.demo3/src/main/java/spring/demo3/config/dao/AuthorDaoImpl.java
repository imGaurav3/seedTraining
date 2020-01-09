package spring.demo3.config.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.demo3.config.model.Author;

@Repository
public class AuthorDaoImpl implements AuthorDao{

	@Autowired
	private SessionFactory sessionFactory;	
	
	@Override
	public List<Author> findAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from Author a",Author.class).getResultList();
	}

	@Override
	public void create(Author a) {
		Session session = sessionFactory.getCurrentSession();
		session.save(a);
		
	}

}
