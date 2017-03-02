package ua.com.shop.validator;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.shop.dto.form.NumberOfSimCardsForm;
import ua.com.shop.service.NumberOfSimCardsService;

public class NumberOfSimCardsValidator implements Validator {

	private final static Pattern REG = Pattern.compile("([0-9]{1})");

	private NumberOfSimCardsService numberOfSimCardsService;

	public NumberOfSimCardsValidator(
			NumberOfSimCardsService numberOfSimCardsService) {
		this.numberOfSimCardsService = numberOfSimCardsService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return NumberOfSimCardsForm.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		NumberOfSimCardsForm form = (NumberOfSimCardsForm) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "simCards", "",
				"Can't be empty");
		if (!REG.matcher(String.valueOf(form.getSimCards())).matches()) {
			errors.rejectValue("simCards", "", "Enter numbers [0-9]{1}!");
		}

		if (errors.getFieldError("simCards") == null) {
			if (numberOfSimCardsService.findUnique(form.getSimCards()) != null) {
				errors.rejectValue("ifExist", "", "Already exist!");
			}
		}
	}

}
