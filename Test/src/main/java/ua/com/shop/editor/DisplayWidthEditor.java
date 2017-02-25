package ua.com.shop.editor;

import java.beans.PropertyEditorSupport;

import ua.com.shop.entity.DisplayWidth;
import ua.com.shop.service.DisplayWidthService;

public class DisplayWidthEditor extends PropertyEditorSupport {

	private final DisplayWidthService displayWidthService;

	public DisplayWidthEditor(DisplayWidthService displayWidthService) {
		this.displayWidthService = displayWidthService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		DisplayWidth displayWidth = displayWidthService.findOne(Integer
				.valueOf(text));
		setValue(displayWidth);
	}

}
