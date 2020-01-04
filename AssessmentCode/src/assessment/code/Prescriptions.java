package assessment.code;

import java.util.Date;

public class Prescriptions {
	
	private int id;
	private Date prescribedDate;
	private int patientId;
	private String medicineName;
	private static int cnt;
	
	public Prescriptions() {
		
	}

	public Prescriptions(int patientId, String medicineName) {
		this.id = cnt++;
		this.patientId = patientId;
		this.medicineName = medicineName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getPrescribedDate() {
		return prescribedDate;
	}

	public void setPrescribedDate(Date prescribedDate) {
		this.prescribedDate = prescribedDate;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	@Override
	public String toString() {
		return "Prescriptions [id=" + id + ", prescribedDate=" + prescribedDate + ", patientId=" + patientId
				+ ", medicineName=" + medicineName + "]";
	}
	
	

}
