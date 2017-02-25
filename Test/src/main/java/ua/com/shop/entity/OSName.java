package ua.com.shop.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class OSName {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@OneToMany(mappedBy="name", fetch = FetchType.LAZY)
	private List<OperatingSystem> operatingSystems;
	
	public OSName() {
	}
	
	public OSName(String name) {
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

	public List<OperatingSystem> getOperatingSystems() {
		return operatingSystems;
	}

	public void setOperatingSystems(List<OperatingSystem> operatingSystems) {
		this.operatingSystems = operatingSystems;
	}

}
