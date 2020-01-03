package hb.demo4.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "vehicle_insurance_details")
//@DiscriminatorValue(value = "V_I")
public class VehicleInsurance extends Insurance{
	
	@Column(name = "vehicle_type_name")
	private String vehicle;
	
	public VehicleInsurance() {
		
	}

	public VehicleInsurance(String vehicle) {
		super();
		this.vehicle = vehicle;
	}

	public String getVehicle() {
		return vehicle;
	}

	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}
	

}
