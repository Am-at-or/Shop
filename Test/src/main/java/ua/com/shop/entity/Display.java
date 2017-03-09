package ua.com.shop.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Display extends AbstractEntity {

	@ManyToOne
	private DisplayValue value;
	@ManyToOne
	private DisplayWidth width;
	@ManyToOne
	private DisplayHeight height;
	@ManyToOne
	private DisplayTechnology technology;
	@OneToMany(mappedBy = "display", fetch = FetchType.LAZY)
	private List<Phone> phones;

	public Display() {
	}

	public DisplayValue getValue() {
		return value;
	}

	public void setValue(DisplayValue value) {
		this.value = value;
	}

	public DisplayWidth getWidth() {
		return width;
	}

	public void setWidth(DisplayWidth width) {
		this.width = width;
	}

	public DisplayHeight getHeight() {
		return height;
	}

	public void setHeight(DisplayHeight height) {
		this.height = height;
	}

	public DisplayTechnology getTechnology() {
		return technology;
	}

	public void setTechnology(DisplayTechnology technology) {
		this.technology = technology;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

}
