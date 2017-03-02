package ua.com.shop.validator;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.shop.dto.form.DisplayWidthForm;
import ua.com.shop.service.DisplayWidthService;

public class DisplayWidthValidator implements Validator {

	private final static Pattern REG1 = Pattern
			.compile("([0-9]{3,4})");

	private DisplayWidthService displayWidthService;

	public DisplayWidthValidator(DisplayWidthService displayWidthService) {
		this.displayWidthService = displayWidthService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return DisplayWidthForm.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		DisplayWidthForm form = (DisplayWidthForm) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "width", "",
				"Can't be empty");
		if (!REG1.matcher(String.valueOf(form.getWidth())).matches()) {
			errors.rejectValue("width", "",
					"Enter numbers [0-9]{3,4}!");
		}

		if (errors.getFieldError("width") == null) {
			if (displayWidthService.findUnique(form.getWidth()) != null) {
				errors.rejectValue("ifExist", "", "Already exist!");
			}
		}
	}

}
