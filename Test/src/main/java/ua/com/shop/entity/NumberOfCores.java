package ua.com.shop.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class NumberOfCores extends AbstractEntity {

	private int cores;
	@OneToMany(mappedBy = "numberOfCores", fetch = FetchType.LAZY)
	private List<Processor> processors;

	public NumberOfCores() {
	}

	public NumberOfCores(int cores) {
		this.cores = cores;
	}

	public int getCores() {
		return cores;
	}

	public void setCores(int cores) {
		this.cores = cores;
	}

	public List<Processor> getProcessors() {
		return processors;
	}

	public void setProcessors(List<Processor> processors) {
		this.processors = processors;
	}

}
