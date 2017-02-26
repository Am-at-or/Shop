package ua.com.shop.editor;

import java.beans.PropertyEditorSupport;

import ua.com.shop.entity.NumberOfCores;
import ua.com.shop.service.NumberOfCoresService;

public class NumberOfCoresEditor extends PropertyEditorSupport {

	private final NumberOfCoresService numberOfCoresService;

	public NumberOfCoresEditor(NumberOfCoresService numberOfCoresService) {
		this.numberOfCoresService = numberOfCoresService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		NumberOfCores numberOfCores = numberOfCoresService.findOne(Integer
				.valueOf(text));
		setValue(numberOfCores);
	}

}
