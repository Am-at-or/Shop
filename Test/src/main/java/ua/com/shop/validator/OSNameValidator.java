package ua.com.shop.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.shop.entity.OSName;
import ua.com.shop.service.OSNameService;

public class OSNameValidator implements Validator {

	private OSNameService osNameService;

	public OSNameValidator(OSNameService osNameService) {
		this.osNameService = osNameService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return OSName.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		OSName osName = (OSName) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "",
				"Can't be empty");
		if (osNameService.findByName(osName.getName()) != null) {
			errors.rejectValue("name", "", "Already exist!");
		}
	}

}
