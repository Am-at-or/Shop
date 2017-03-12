package ua.com.shop.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.shop.dto.form.DisplayResolutionForm;
import ua.com.shop.service.DisplayResolutionService;

public class DisplayValidator implements Validator {

	private DisplayResolutionService displayService;

	public DisplayValidator(DisplayResolutionService displayService) {
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
		if (errors.getFieldError("width") == null
				&& errors.getFieldError("height") == null) {
			if (displayService.findUnique(form.getWidth(), form.getHeight()) != null) {
				errors.rejectValue("ifExist", "", "Already exist!");
			}
		}
	}

}