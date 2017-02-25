package ua.com.shop.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class DisplayWidth extends AbstractEntity {

	private int width;
	@OneToMany(mappedBy = "width", fetch = FetchType.LAZY)
	private List<Display> displays;

	public DisplayWidth() {
	}

	public DisplayWidth(int width) {
		this.width = width;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public List<Display> getDisplays() {
		return displays;
	}

	public void setDisplays(List<Display> displays) {
		this.displays = displays;
	}

}
