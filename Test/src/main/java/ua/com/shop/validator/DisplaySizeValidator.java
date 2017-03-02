package ua.com.shop.validator;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.shop.dto.form.DisplaySizeForm;
import ua.com.shop.service.DisplaySizeService;

public class DisplaySizeValidator implements Validator {

	private final static Pattern REG1 = Pattern
			.compile("([0-9]{1,2}\\.[0-9]{1,2})|([0-9]{1,2})");

	private final DisplaySizeService displaySizeService;

	public DisplaySizeValidator(DisplaySizeService displaySizeService) {
		this.displaySizeService = displaySizeService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return DisplaySizeForm.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		DisplaySizeForm form = (DisplaySizeForm) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "size", "",
				"Can't be empty");
		if (!REG1.matcher(String.valueOf(form.getSize())).matches()) {
			errors.rejectValue("size", "",
					"Enter numbers [0-9]{1,2}\\.[0-9]{1,2}!");
		}

		if (errors.getFieldError("size") == null) {
			if (displaySizeService.findUnique(form.getSize()) != null) {
				errors.rejectValue("ifExist", "", "Already exist!");
			}
		}
	}

}
