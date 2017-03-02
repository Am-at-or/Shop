package ua.com.shop.validator;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.shop.dto.form.CardMemoryForm;
import ua.com.shop.service.CardMemoryService;

public class CardMemoryValidator implements Validator {

	private final static Pattern REG = Pattern.compile("([0-9]{1})");

	private CardMemoryService cardMemoryService;

	public CardMemoryValidator(CardMemoryService cardMemoryService) {
		;
		this.cardMemoryService = cardMemoryService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return CardMemoryForm.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		CardMemoryForm form = (CardMemoryForm) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "card", "",
				"Can't be empty");
		if (!REG.matcher(String.valueOf(form.getCard())).matches()) {
			errors.rejectValue("card", "", "Enter numbers [0-9]{1}!");
		}

		if (errors.getFieldError("card") == null) {
			if (cardMemoryService.findUnique(form.getCard()) != null) {
				errors.rejectValue("ifExist", "", "Already exist!");
			}
		}
	}

}
