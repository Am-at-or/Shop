package ua.com.shop.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class NumberOfCores extends AbstractEntity {

	private String cores;
	@OneToMany(mappedBy = "numberOfCores", fetch = FetchType.LAZY)
	private List<Processor> processors;

	public NumberOfCores() {
	}

	public String getCores() {
		return cores;
	}

	public void setCores(String cores) {
		this.cores = cores;
	}

	public List<Processor> getProcessors() {
		return processors;
	}

	public void setProcessors(List<Processor> processors) {
		this.processors = processors;
	}

}
