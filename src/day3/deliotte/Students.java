package day3.deliotte;

public class Students implements Comparable<Students>{
	
	private int id;
	private String name;
	private String email;
	private static int count;
	
	public Students() {
		
	}
	public Students(String name, String email) {
		this.id = count++;
		this.name = name;
		this.email = email;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Students [id=" + id + ", name=" + name + ", email=" + email + "]";
	}
	
	@Override
	public int compareTo(Students o) {
		
		if(id > o.getId())
			return 1;
		else
			return -1;
	}
	

}
