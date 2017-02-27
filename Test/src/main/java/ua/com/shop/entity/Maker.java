package ua.com.shop.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class Maker extends AbstractEntity {

	private String name;
	@OneToMany(mappedBy = "maker", fetch = FetchType.LAZY)
	private List<Phone> phones;

	public Maker() {
	}

	public Maker(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

}
