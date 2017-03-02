package ua.com.shop.editor;

import java.beans.PropertyEditorSupport;

import ua.com.shop.entity.InternalMemory;
import ua.com.shop.service.InternalMemoryService;

public class InternalMemoryEditor extends PropertyEditorSupport {

	private final InternalMemoryService internalMemoryService;

	public InternalMemoryEditor(InternalMemoryService internalMemoryService) {
		this.internalMemoryService = internalMemoryService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		InternalMemory internalMemory = internalMemoryService.findOne(Integer
				.valueOf(text));
		setValue(internalMemory);
	}

}
