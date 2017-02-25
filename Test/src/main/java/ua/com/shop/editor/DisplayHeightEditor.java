package ua.com.shop.editor;

import java.beans.PropertyEditorSupport;

import ua.com.shop.entity.DisplayHeight;
import ua.com.shop.service.DisplayHeightService;

public class DisplayHeightEditor extends PropertyEditorSupport {

	private final DisplayHeightService displayHeightService;

	public DisplayHeightEditor(DisplayHeightService displayHeightService) {
		this.displayHeightService = displayHeightService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		DisplayHeight displayHeight = displayHeightService.findOne(Integer
				.valueOf(text));
		setValue(displayHeight);
	}

}
