package assessment.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "web_medicine")
public class Medicine {
	
	@Id
	@Column(name = "ID")
	private int id;
	
	@Column(name = "Name")
	private String name;
	
	@ManyToMany
	private List<Prescription> prescriptions;
	
	public Medicine() {
		
	}

//	public Medicine(int id, String name) {
//		this.id = id;
//		this.name = name;
//	}

	public Medicine(int id, String name, List<Prescription> prescriptions) {
		super();
		this.id = id;
		this.name = name;
		this.prescriptions = prescriptions;
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

	public List<Prescription> getPrescriptions() {
		return prescriptions;
	}

	public void setPrescriptions(List<Prescription> prescriptions) {
		this.prescriptions = prescriptions;
	}
	
	

}
