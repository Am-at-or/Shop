package ua.com.shop.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Processor extends AbstractEntity {

	@ManyToOne
	private ProcessorMaker maker;
	private String model;
	private double frequency;
	@ManyToOne
	private NumberOfCores numberOfCores;
	@OneToMany(mappedBy = "processor", fetch = FetchType.LAZY)
	private List<Phone> phones;

	public Processor() {
	}

	public ProcessorMaker getMaker() {
		return maker;
	}

	public void setMaker(ProcessorMaker maker) {
		this.maker = maker;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getFrequency() {
		return frequency;
	}

	public void setFrequency(double frequency) {
		this.frequency = frequency;
	}

	public NumberOfCores getNumberOfCores() {
		return numberOfCores;
	}

	public void setNumberOfCores(NumberOfCores numberOfCores) {
		this.numberOfCores = numberOfCores;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

}
