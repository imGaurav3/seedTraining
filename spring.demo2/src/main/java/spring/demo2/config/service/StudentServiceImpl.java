package spring.demo2.config.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.demo2.config.dao.StudentDao;
import spring.demo2.config.model.Student;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentDao studentDao;
	
	
	@PostConstruct
	private void init() {
		System.out.println("StudentService Data access object class created");
	}
	
	@PreDestroy
	private void destroy() {
		System.out.println("StudentService Data access object class is about to be destroyed");
	}
	
	
	@Override
	@Transactional
	public List<Student> findAll() {
		
		return studentDao.findAll();
	}

	@Override
	@Transactional
	public void create(Student s) {
		studentDao.create(s);
	}

		
}
