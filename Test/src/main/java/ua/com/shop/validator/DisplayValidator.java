package ua.com.shop.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import ua.com.shop.entity.Display;
import ua.com.shop.service.DisplayService;

public class DisplayValidator implements Validator {

	private DisplayService displayService;

	public DisplayValidator(DisplayService displayService) {
		this.displayService = displayService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return Display.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Display display = (Display) target;
		if (displayService.findUnique(display.getSize(), display.getWidth(),
				display.getHeight(), display.getTechnology()) != null) {
			errors.rejectValue("technology", "", "Already exist!");
		}
	}

}