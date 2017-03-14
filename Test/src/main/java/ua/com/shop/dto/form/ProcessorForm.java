package ua.com.shop.dto.form;

import ua.com.shop.entity.ProcessorMaker;

public class ProcessorForm {

	private int id;
	private ProcessorMaker maker;
	private String model;
	private String frequency;
	private String numberOfCores;
	private String ifExist;

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

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public String getNumberOfCores() {
		return numberOfCores;
	}

	public void setNumberOfCores(String numberOfCores) {
		this.numberOfCores = numberOfCores;
	}

	public String getIfExist() {
		return ifExist;
	}

	public void setIfExist(String ifExist) {
		this.ifExist = ifExist;
	}

}
