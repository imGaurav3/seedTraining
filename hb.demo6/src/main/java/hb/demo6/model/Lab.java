package hb.demo6.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_lab")
public class Lab {
	
	@Id
	@Column(name = "Id")
	private int id;
	
	@Column(name = "Name")
	private String name;
	
	@Column(name = "PC_Count")
	private int pcCount;
	
	public Lab() {
		
	}

	public Lab(int id, String name, int pcCount) {
		this.id = id;
		this.name = name;
		this.pcCount = pcCount;
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

	public int getPcCount() {
		return pcCount;
	}

	public void setPcCount(int pcCount) {
		this.pcCount = pcCount;
	}
	
	

}
