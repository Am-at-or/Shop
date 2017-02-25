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
public class Display extends AbstractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	private DisplaySize size;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public DisplaySize getSize() {
		return size;
	}

	public void setSize(DisplaySize size) {
		this.size = size;
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
