package assessment.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="web_prescription")
public class Prescription {
	
	@Id
	@Column(name = "ID")
	private int id;
	
	@Column(name = "Prescribed_Date")
	private String prescribedDate;
	
	@ManyToOne
	private Patient patient;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "Prescription_id")
	private List<Medicine> medicines;
	
	public Prescription() {
		
	}

	public Prescription(int id, String prescribedDate, Patient patient) {
		this.id = id;
		this.prescribedDate = prescribedDate;
		this.patient = patient;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPrescribedDate() {
		return prescribedDate;
	}

	public void setPrescribedDate(String prescribedDate) {
		this.prescribedDate = prescribedDate;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public List<Medicine> getMedicines() {
		return medicines;
	}

	public void setMedicines(List<Medicine> medicines) {
		this.medicines = medicines;
	}
	
	

}
