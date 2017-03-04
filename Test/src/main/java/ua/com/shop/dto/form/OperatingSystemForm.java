package ua.com.shop.dto.form;

import ua.com.shop.entity.OSName;

public class OperatingSystemForm {

	private int id;
	private OSName name;
	private String version;
	private String ifExist;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public OSName getName() {
		return name;
	}

	public void setName(OSName name) {
		this.name = name;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getIfExist() {
		return ifExist;
	}

	public void setIfExist(String ifExist) {
		this.ifExist = ifExist;
	}

}
