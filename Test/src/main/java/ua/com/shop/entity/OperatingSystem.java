package ua.com.shop.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class OperatingSystem extends AbstractEntity {

	@ManyToOne
	private OSName name;
	private double version;
	@OneToMany(mappedBy = "operatingSystem", fetch = FetchType.LAZY)
	private List<Phone> phones;

	public OperatingSystem() {
	}

	public OSName getName() {
		return name;
	}

	public void setName(OSName name) {
		this.name = name;
	}

	public double getVersion() {
		return version;
	}

	public void setVersion(double version) {
		this.version = version;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

}
