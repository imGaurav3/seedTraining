package hb.demo4.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;


@MappedSuperclass
//@Entity
@Table(name = "insurance_details")
@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorColumn(name = "ins_type",discriminatorType = DiscriminatorType.STRING)
public class Insurance {
	
	@Id
	@Column(name = "ins_id")
	private int id;
	
	@Column(name = "ins_amt")
	private int sumInsured;
	
	@Column(name = "ins_name")
	private String name;
	
	public Insurance() {
		
	}

	public Insurance(int id, int sumInsured, String insured) {
		this.id = id;
		this.sumInsured = sumInsured;
		this.name = insured;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSumInsured() {
		return sumInsured;
	}

	public void setSumInsured(int sumInsured) {
		this.sumInsured = sumInsured;
	}

	public String getInsured() {
		return name;
	}

	public void setInsured(String insured) {
		this.name = insured;
	}
	

}
