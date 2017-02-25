package ua.com.shop.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ProcessorMaker {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String maker;
	@OneToMany(mappedBy="maker", fetch = FetchType.LAZY)
	private List<Processor> processors;
	
	public ProcessorMaker() {
	}

	public ProcessorMaker(String maker) {
		this.maker = maker;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public List<Processor> getProcessors() {
		return processors;
	}

	public void setProcessors(List<Processor> processors) {
		this.processors = processors;
	}
	
}
