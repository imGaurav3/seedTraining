package hb.demo2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Teachers")
public class Teacher {
	
	@Id
	@Column(name="ID")
	private int id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="Department")
	private String department;
	
	@Column(name="AGE")
	private int age;
	
	
	public Teacher() {
		
	}


	public Teacher(int id, String name, String department, int age) {
		this.id = id;
		this.name = name;
		this.department = department;
		this.age = age;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}
	

}
