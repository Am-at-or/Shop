package ua.com.shop.editor;

import java.beans.PropertyEditorSupport;

import ua.com.shop.entity.DisplayTechnology;
import ua.com.shop.service.DisplayTechnologyService;

public class DisplayTechnologyEditor extends PropertyEditorSupport {

	private final DisplayTechnologyService displayTechnologyService;

	public DisplayTechnologyEditor(
			DisplayTechnologyService displayTechnologyService) {
		this.displayTechnologyService = displayTechnologyService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		DisplayTechnology displayTechnology = displayTechnologyService
				.findOne(Integer.valueOf(text));
		setValue(displayTechnology);
	}

}
