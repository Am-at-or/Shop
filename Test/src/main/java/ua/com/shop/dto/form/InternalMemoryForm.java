package ua.com.shop.dto.form;

public class InternalMemoryForm {

	private int id;
	private String internal;
	private String ifExist;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInternal() {
		return internal;
	}

	public void setInternal(String internal) {
		this.internal = internal;
	}

	public String getIfExist() {
		return ifExist;
	}

	public void setIfExist(String ifExist) {
		this.ifExist = ifExist;
	}

}
