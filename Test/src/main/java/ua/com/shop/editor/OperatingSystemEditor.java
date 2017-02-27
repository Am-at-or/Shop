package ua.com.shop.editor;

import java.beans.PropertyEditorSupport;

import ua.com.shop.entity.OperatingSystem;
import ua.com.shop.service.OperatingSystemService;

public class OperatingSystemEditor extends PropertyEditorSupport {

	private final OperatingSystemService operatingSystemService;

	public OperatingSystemEditor(OperatingSystemService operatingSystemService) {
		this.operatingSystemService = operatingSystemService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		OperatingSystem operatingSystem = operatingSystemService
				.findOne(Integer.valueOf(text));
		setValue(operatingSystem);
	}

}
