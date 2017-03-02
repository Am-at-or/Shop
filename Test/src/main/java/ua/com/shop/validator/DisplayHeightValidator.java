package ua.com.shop.validator;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.shop.dto.form.DisplayHeightForm;
import ua.com.shop.service.DisplayHeightService;

public class DisplayHeightValidator implements Validator {

	private final static Pattern REG1 = Pattern.compile("([0-9]{3,4})");

	private DisplayHeightService displayHeightService;

	public DisplayHeightValidator(DisplayHeightService displayHeightService) {
		this.displayHeightService = displayHeightService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return DisplayHeightForm.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		DisplayHeightForm form = (DisplayHeightForm) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "height", "",
				"Can't be empty");
		if (!REG1.matcher(String.valueOf(form.getHeight())).matches()) {
			errors.rejectValue("height", "", "Enter numbers [0-9]{3,4}!");
		}

		if (errors.getFieldError("height") == null) {
			if (displayHeightService.findUnique(form.getHeight()) != null) {
				errors.rejectValue("ifExist", "", "Already exist!");
			}
		}
	}

}
