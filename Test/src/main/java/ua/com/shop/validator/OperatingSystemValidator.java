package ua.com.shop.validator;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.shop.dto.form.OperatingSystemForm;
import ua.com.shop.service.OperatingSystemService;

public class OperatingSystemValidator implements Validator {

	private final static Pattern REG = Pattern
			.compile("([0-9]{1,2}\\.[0-9]{1,2})|([0-9]{1,2}\\,[0-9]{1,2})");

	private OperatingSystemService operatingSystemService;

	public OperatingSystemValidator(
			OperatingSystemService operatingSystemService) {
		this.operatingSystemService = operatingSystemService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return OperatingSystemForm.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		OperatingSystemForm form = (OperatingSystemForm) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "version", "",
				"Can't be empty");
		if (!REG.matcher(form.getVersion()).matches()) {
			errors.rejectValue("version", "",
					"Enter numbers [0-9]{1,9}\\.[0-9]{1,2}!");
		}
		if (errors.getFieldError("version") == null) {
			if (operatingSystemService.findUnique(form.getName(),
					form.getVersion()) != null) {
				errors.rejectValue("version", "", "Already exist!");
			}
		}
	}

}
