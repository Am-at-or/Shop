package ua.com.shop.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class DisplayValue extends AbstractEntity {

	private double value;
	@OneToMany(mappedBy = "value", fetch = FetchType.LAZY)
	private List<Display> displays;

	public DisplayValue() {
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public List<Display> getDisplays() {
		return displays;
	}

	public void setDisplays(List<Display> displays) {
		this.displays = displays;
	}

}
