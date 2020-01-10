package assessment.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "web_patients")
public class Patient {
	
	@Id
	@Column(name = "ID")
	private int id;
	
	
	@Column(name = "Name")
	private String name;
	
	@Column(name = "Email")	
	private String email;
	
	@Column(name = "Reg_Date")
	private String Date;
	
	private static int count=1;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "Patient_id")
	private List<Prescription> prescriptions;
	
	public Patient() {
		
	}

	public Patient(int id,String name, String email, String date) {
		this.id = id;
		this.name = name;
		this.email = email;
		Date = date;
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

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public List<Prescription> getPrescriptions() {
		return prescriptions;
	}

	public void setPrescriptions(List<Prescription> prescriptions) {
		this.prescriptions = prescriptions;
	}
	
	
	

}
