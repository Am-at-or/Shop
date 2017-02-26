package ua.com.shop.editor;

import java.beans.PropertyEditorSupport;

import ua.com.shop.entity.ProcessorMaker;
import ua.com.shop.service.ProcessorMakerService;

public class ProcessorMakerEditor extends PropertyEditorSupport {

	private final ProcessorMakerService processorMakerService;

	public ProcessorMakerEditor(ProcessorMakerService processorMakerService) {
		this.processorMakerService = processorMakerService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		ProcessorMaker processorMaker = processorMakerService.findOne(Integer
				.valueOf(text));
		setValue(processorMaker);
	}

}
