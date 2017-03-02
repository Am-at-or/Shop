package ua.com.shop.dto.form;

public class NumberOfCoresForm {

	private int id;
	private String cores;
	private String ifExist;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCores() {
		return cores;
	}

	public void setCores(String cores) {
		this.cores = cores;
	}

	public String getIfExist() {
		return ifExist;
	}

	public void setIfExist(String ifExist) {
		this.ifExist = ifExist;
	}

}
