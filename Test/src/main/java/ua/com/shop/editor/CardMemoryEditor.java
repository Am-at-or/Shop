package ua.com.shop.editor;

import java.beans.PropertyEditorSupport;

import ua.com.shop.entity.CardMemory;
import ua.com.shop.service.CardMemoryService;

public class CardMemoryEditor extends PropertyEditorSupport {

	private final CardMemoryService cardMemoryService;

	public CardMemoryEditor(CardMemoryService cardMemoryService) {
		this.cardMemoryService = cardMemoryService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		CardMemory cardMemory = cardMemoryService
				.findOne(Integer.valueOf(text));
		setValue(cardMemory);
	}

}
