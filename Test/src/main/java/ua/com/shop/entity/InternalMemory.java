package ua.com.shop.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class InternalMemory extends AbstractEntity {

	private int internal;
	@OneToMany(mappedBy = "internal", fetch = FetchType.LAZY)
	private List<Phone> phones;

	public InternalMemory() {
	}

	public InternalMemory(int internal, List<Phone> phones) {
	}

	public int getInternal() {
		return internal;
	}

	public void setInternal(int internal) {
		this.internal = internal;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

}
