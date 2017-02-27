package ua.com.shop.editor;

import java.beans.PropertyEditorSupport;

import ua.com.shop.entity.Processor;
import ua.com.shop.service.ProcessorService;

public class ProcessorEditor extends PropertyEditorSupport {

	private final ProcessorService processorService;

	public ProcessorEditor(ProcessorService processorService) {
		this.processorService = processorService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Processor processor = processorService.findOne(Integer.valueOf(text));
		setValue(processor);
	}

}
