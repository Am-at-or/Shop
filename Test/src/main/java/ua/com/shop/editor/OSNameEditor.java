package ua.com.shop.editor;

import java.beans.PropertyEditorSupport;

import ua.com.shop.entity.OSName;
import ua.com.shop.service.OSNameService;

public class OSNameEditor extends PropertyEditorSupport {

	private final OSNameService osNameService;

	public OSNameEditor(OSNameService osNameService) {
		this.osNameService = osNameService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		OSName osName = osNameService.findOne(Integer.valueOf(text));
		setValue(osName);
	}

}
