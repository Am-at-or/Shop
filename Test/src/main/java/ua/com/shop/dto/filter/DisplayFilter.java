package ua.com.shop.dto.filter;

import java.util.ArrayList;
import java.util.List;

public class DisplayFilter {

	private List<Integer> displayValueIds = new ArrayList<>();
	private List<Integer> displayWidthIds = new ArrayList<>();
	private List<Integer> displayHeightIds = new ArrayList<>();
	private List<Integer> displayTechnologyIds = new ArrayList<>();

	public List<Integer> getDisplayValueIds() {
		return displayValueIds;
	}

	public void setDisplayValueIds(List<Integer> displayValueIds) {
		this.displayValueIds = displayValueIds;
	}

	public List<Integer> getDisplayWidthIds() {
		return displayWidthIds;
	}

	public void setDisplayWidthIds(List<Integer> displayWidthIds) {
		this.displayWidthIds = displayWidthIds;
	}

	public List<Integer> getDisplayHeightIds() {
		return displayHeightIds;
	}

	public void setDisplayHeightIds(List<Integer> displayHeightIds) {
		this.displayHeightIds = displayHeightIds;
	}

	public List<Integer> getDisplayTechnologyIds() {
		return displayTechnologyIds;
	}

	public void setDisplayTechnologyIds(List<Integer> displayTechnologyIds) {
		this.displayTechnologyIds = displayTechnologyIds;
	}

}
