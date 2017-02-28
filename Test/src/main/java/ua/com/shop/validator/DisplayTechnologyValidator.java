package ua.com.shop.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.shop.entity.DisplayTechnology;
import ua.com.shop.service.DisplayTechnologyService;

public class DisplayTechnologyValidator implements Validator {

	private DisplayTechnologyService displayTechnologyService;

	public DisplayTechnologyValidator(
			DisplayTechnologyService displayTechnologyService) {
		this.displayTechnologyService = displayTechnologyService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return DisplayTechnology.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		DisplayTechnology displayTechnology = (DisplayTechnology) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "technology", "",
				"Can't be empty");
		if (displayTechnologyService.findByDisplayTechnology(displayTechnology
				.getTechnology()) != null) {
			errors.rejectValue("technology", "", "Already exist!");
		}
	}

}
