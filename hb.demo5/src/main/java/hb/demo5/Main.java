package hb.demo5;

import java.util.ArrayList;
import java.util.List;

import hb.demo5.model.EntityDao;
import hb.demo5.model.Students;
import hb.demo5.model.Teacher;

public class Main {

	public static void main(String[] args) {
		
		Teacher t = new Teacher(34, "Dan", "CS", 40);
		
		List<Students> students = new ArrayList<Students>();
		
		
		students.add(new  Students(25, "Shivani", "sh@gmail.com"));
		students.add(new  Students(26, "Maithili", "maith@gmail.com"));
		students.add(new  Students(27, "Maithili", "maith@gmail.com"));
		
		t.setStudents(students);
		
		
		EntityDao.createTeacher(t);
		
		EntityDao.shutdown();
		
	}

}
