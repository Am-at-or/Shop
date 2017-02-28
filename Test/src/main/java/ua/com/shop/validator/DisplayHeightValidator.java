package ua.com.shop.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.shop.entity.DisplayHeight;
import ua.com.shop.service.DisplayHeightService;

public class DisplayHeightValidator implements Validator {

	private DisplayHeightService displayHeightService;

	public DisplayHeightValidator(DisplayHeightService displayHeightService) {
		this.displayHeightService = displayHeightService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return DisplayHeight.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		DisplayHeight displayHeight = (DisplayHeight) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "height", "",
				"Can't be empty");
		if (displayHeightService.findByDisplayHeight(displayHeight.getHeight()) != null) {
			errors.rejectValue("height", "", "Already exist!");
		}
	}

}
