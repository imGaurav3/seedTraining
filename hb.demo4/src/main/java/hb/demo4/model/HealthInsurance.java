package hb.demo4.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "health_insurance_details")
//@DiscriminatorValue(value = "H_I")
public class HealthInsurance extends Insurance{

	
	@Column(name = "health_plan_name")
	private String healthPlan;
	
	public HealthInsurance() {
		
	}

	public HealthInsurance(String healthPlan) {
		super();
		this.healthPlan = healthPlan;
	}

	public String getHealthPlan() {
		return healthPlan;
	}

	public void setHealthPlan(String healthPlan) {
		this.healthPlan = healthPlan;
	}
	
	
	
}
