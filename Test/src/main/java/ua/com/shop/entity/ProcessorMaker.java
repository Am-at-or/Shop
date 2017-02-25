package ua.com.shop.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class ProcessorMaker extends AbstractEntity {

	private String maker;
	@OneToMany(mappedBy = "maker", fetch = FetchType.LAZY)
	private List<Processor> processors;

	public ProcessorMaker() {
	}

	public ProcessorMaker(String maker) {
		this.maker = maker;
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
