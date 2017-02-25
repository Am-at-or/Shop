package ua.com.shop.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Processor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	private ProcessorMaker maker;
	private String name;
	private int frequency;
	@ManyToOne
	private NumberOfCores numberOfCores;
	@OneToMany(mappedBy = "processor", fetch = FetchType.LAZY)
	private List<Phone> phones;

	public Processor() {
	}

	public Processor(String name, int frequency) {
		this.name = name;
		this.frequency = frequency;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ProcessorMaker getMaker() {
		return maker;
	}

	public void setMaker(ProcessorMaker maker) {
		this.maker = maker;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
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
