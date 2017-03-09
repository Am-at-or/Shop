package ua.com.shop.validator;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.shop.dto.form.DisplayValueForm;
import ua.com.shop.service.DisplayValueService;

public class DisplayValueValidator implements Validator {

	private final static Pattern REG1 = Pattern
			.compile("([0-9]{1,2}\\.[0-9]{1,2})|([0-9]{1,2})");

	private final DisplayValueService displayValueService;

	public DisplayValueValidator(DisplayValueService displayValueService) {
		this.displayValueService = displayValueService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return DisplayValueForm.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		DisplayValueForm form = (DisplayValueForm) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "value", "",
				"Can't be empty");
		if (!REG1.matcher(String.valueOf(form.getValue())).matches()) {
			errors.rejectValue("value", "",
					"Enter numbers [0-9]{1,2}\\.[0-9]{1,2}!");
		}

		if (errors.getFieldError("size") == null) {
			if (displayValueService.findUnique(form.getValue()) != null) {
				errors.rejectValue("ifExist", "", "Already exist!");
			}
		}
	}

}
