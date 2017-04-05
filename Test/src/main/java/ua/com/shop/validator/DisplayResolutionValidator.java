package ua.com.shop.validator;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.shop.dto.form.DisplayResolutionForm;
import ua.com.shop.service.DisplayResolutionService;

public class DisplayResolutionValidator implements Validator {
	
	private final static Pattern REG1 = Pattern
			.compile("([0-9]{1,9})");

	private DisplayResolutionService displayService;

	public DisplayResolutionValidator(DisplayResolutionService displayService) {
		this.displayService = displayService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return DisplayResolutionForm.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		DisplayResolutionForm form = (DisplayResolutionForm) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "width", "",
				"Can't be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "height", "",
				"Can't be empty");
		if (!REG1.matcher(form.getWidth()).matches()) {
			errors.rejectValue("width", "", "Error");
		}
		if (!REG1.matcher(form.getHeight()).matches()) {
			errors.rejectValue("height", "", "Error");
		}
		if (errors.getFieldError("width") == null
				&& errors.getFieldError("height") == null) {
			if (displayService.findUnique(form.getWidth(), form.getHeight()) != null) {
				errors.rejectValue("ifExist", "", "Already exist!");
			}
		}
	}

}