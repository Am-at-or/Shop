package ua.com.shop.editor;

import java.beans.PropertyEditorSupport;

import ua.com.shop.entity.NumberOfSimCards;
import ua.com.shop.service.NumberOfSimCardsService;

public class NumberOfSimCardsEditor extends PropertyEditorSupport {

	private final NumberOfSimCardsService numberOfSimCardsService;

	public NumberOfSimCardsEditor(
			NumberOfSimCardsService numberOfSimCardsService) {
		this.numberOfSimCardsService = numberOfSimCardsService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		NumberOfSimCards numberOfSimCards = numberOfSimCardsService
				.findOne(Integer.valueOf(text));
		setValue(numberOfSimCards);
	}

}
