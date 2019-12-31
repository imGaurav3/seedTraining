package day3.deliotte;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DataManager {
	
	private List<Students> student;
	
	public DataManager() {
		student = new ArrayList<>();
	}
	
	public void add(Students s) {
		student.add(s);
	}
	
	public void print() {
		for(Students s : student) {
			System.out.println(s);
		}
	}
	public void defaultSort() {
		Collections.sort(student);
	}
	public void namesort() {
		Collections.sort(student,new NameSort());
	}
	public void emailSort() {
		Collections.sort(student,new Comparator<Students>() {
			
			@Override
			public int compare(Students o1, Students o2) {
				
				return o1.getEmail().compareTo(o2.getEmail());
			}
		});
	}
	
	class NameSort implements Comparator<Students>{

		@Override
		public int compare(Students o1, Students o2) {
			
			return o1.getName().compareTo(o2.getName());
		}
		
	}

}
