package spring.demo2.config.dao;

import java.util.List;

import spring.demo2.config.model.Student;

public interface StudentDao {
	
	public List<Student> findAll();
	
	public void create(Student s);

}
