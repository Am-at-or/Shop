package ua.com.shop.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class DisplaySize extends AbstractEntity {

	private double size;
	@OneToMany(mappedBy = "size", fetch = FetchType.LAZY)
	private List<Display> displays;

	public DisplaySize() {
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

	public List<Display> getDisplays() {
		return displays;
	}

	public void setDisplays(List<Display> displays) {
		this.displays = displays;
	}

}
