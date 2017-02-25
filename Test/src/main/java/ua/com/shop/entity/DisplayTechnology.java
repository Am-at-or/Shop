package ua.com.shop.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class DisplayTechnology extends AbstractEntity {

	private String technology;
	@OneToMany(mappedBy = "technology", fetch = FetchType.LAZY)
	private List<Display> displays;

	public DisplayTechnology() {
	}

	public DisplayTechnology(String technology) {
		super();
		this.technology = technology;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public List<Display> getDisplays() {
		return displays;
	}

	public void setDisplays(List<Display> displays) {
		this.displays = displays;
	}

}
