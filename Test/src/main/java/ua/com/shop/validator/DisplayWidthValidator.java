package ua.com.shop.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.shop.entity.DisplayWidth;
import ua.com.shop.service.DisplayWidthService;

public class DisplayWidthValidator implements Validator {

	private DisplayWidthService displayWidthService;

	public DisplayWidthValidator(DisplayWidthService displayWidthService) {
		this.displayWidthService = displayWidthService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return DisplayWidth.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		DisplayWidth displayWidth = (DisplayWidth) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "width", "",
				"Can't be empty");
		if (displayWidthService.findByDisplayWidth(displayWidth.getWidth()) != null) {
			errors.rejectValue("width", "", "Already exist!");
		}
	}

}
