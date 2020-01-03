package hb.demo6.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_batch")
public class Batch {
	
	@Id
	@Column(name = "Id")
	private int id;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "batch_id")
	private List<Trainee> trainees;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "batch_id")
	private Trainer trainer;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "batch_id")
	private Lab lab;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "batch_id")
	private Schedule schedule;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "batch_id")
	private Curriculum curriculum;
	
	public Batch() {
		
	}

	public Batch(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Trainee> getTrainees() {
		return trainees;
	}

	public void setTrainees(List<Trainee> trainees) {
		this.trainees = trainees;
	}

	public Trainer getTrainer() {
		return trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}

	public Lab getLab() {
		return lab;
	}

	public void setLab(Lab lab) {
		this.lab = lab;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public Curriculum getCurriculum() {
		return curriculum;
	}

	public void setCurriculum(Curriculum curriculum) {
		this.curriculum = curriculum;
	}
	
	

}
