package hb.demo6.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_trainee")
public class Trainee {
	
	@Id
	@Column(name = "Id")
	private int id;
	
	@Column(name = "Name")
	private String name;
	
	@ManyToOne
	private Trainer trainer;
	
	public Trainee() {
		
	}

	public Trainee(int id, String name) {
		this.id = id;
		this.name = name;
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

	public Trainer getTrainer() {
		return trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}
	

}
