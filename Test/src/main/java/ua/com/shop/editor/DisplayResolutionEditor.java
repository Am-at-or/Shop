package ua.com.shop.editor;

import java.beans.PropertyEditorSupport;

import ua.com.shop.entity.DisplayResolution;
import ua.com.shop.service.DisplayResolutionService;

public class DisplayResolutionEditor extends PropertyEditorSupport {

	private final DisplayResolutionService displayResolutionService;

	public DisplayResolutionEditor(
			DisplayResolutionService displayResolutionService) {
		this.displayResolutionService = displayResolutionService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		DisplayResolution displayResolution = displayResolutionService
				.findOne(Integer.valueOf(text));
		setValue(displayResolution);
	}

}
