package hb.demo6.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_curriculum")
public class Curriculum {
	
	@Id
	@Column(name = "Id")
	private int id;
	
	@Column(name = "topics")
	private String topics;
	
	@OneToOne
	private Batch batch;
	
	public Curriculum() {
		
	}

	public Curriculum(int id, String topics) {
		this.id = id;
		this.topics = topics;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTopics() {
		return topics;
	}

	public void setTopics(String topics) {
		this.topics = topics;
	}

	public Batch getBatch() {
		return batch;
	}

	public void setBatch(Batch batch) {
		this.batch = batch;
	}
	
	
}
