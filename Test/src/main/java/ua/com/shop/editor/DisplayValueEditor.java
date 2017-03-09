package ua.com.shop.editor;

import java.beans.PropertyEditorSupport;

import ua.com.shop.entity.DisplayValue;
import ua.com.shop.service.DisplayValueService;

public class DisplayValueEditor extends PropertyEditorSupport {

	private final DisplayValueService displayValueService;

	public DisplayValueEditor(DisplayValueService displayValueService) {
		this.displayValueService = displayValueService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		DisplayValue displayValue = displayValueService.findOne(Integer
				.valueOf(text));
		setValue(displayValue);
	}

}
