package ua.com.shop.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.shop.entity.DisplaySize;
import ua.com.shop.service.DisplaySizeService;

public class DisplaySizeValidator implements Validator {

	private final DisplaySizeService displaySizeService;

	public DisplaySizeValidator(DisplaySizeService displaySizeService) {
		this.displaySizeService = displaySizeService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return DisplaySize.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		DisplaySize displaySize = (DisplaySize) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "size", "",
				"Can't be empty");
		if (displaySizeService.findByDisplaySize(displaySize.getSize()) != null) {
			errors.rejectValue("size", "", "Already exist!");
		}
	}

}
