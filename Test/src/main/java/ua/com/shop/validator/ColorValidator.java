package ua.com.shop.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.shop.entity.Color;
import ua.com.shop.service.ColorService;

public class ColorValidator implements Validator {

	private ColorService colorService;

	public ColorValidator(ColorService colorService) {
		this.colorService = colorService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return Color.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Color color = (Color) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "color", "",
				"Can't be empty");
		if (colorService.findByColor(color.getColor()) != null) {
			errors.rejectValue("color", "", "Already exist!");
		}
	}

}
