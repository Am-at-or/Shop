package ua.com.shop.editor;

import java.beans.PropertyEditorSupport;

import ua.com.shop.entity.DisplaySize;
import ua.com.shop.service.DisplaySizeService;

public class DisplaySizeEditor extends PropertyEditorSupport {

	private final DisplaySizeService displaySizeService;

	public DisplaySizeEditor(DisplaySizeService displaySizeService) {
		this.displaySizeService = displaySizeService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		DisplaySize displaySize = displaySizeService.findOne(Integer
				.valueOf(text));
		setValue(displaySize);
	}

}
