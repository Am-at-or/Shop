package ua.com.shop.editor;

import java.beans.PropertyEditorSupport;

import ua.com.shop.entity.Display;
import ua.com.shop.service.DisplayService;

public class DisplayEditor extends PropertyEditorSupport {

	private final DisplayService displayService;

	public DisplayEditor(DisplayService displayService) {
		this.displayService = displayService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Display display = displayService.findOne(Integer.valueOf(text));
		setValue(display);
	}

}
