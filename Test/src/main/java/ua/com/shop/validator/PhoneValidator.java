package ua.com.shop.validator;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.shop.dto.form.PhoneForm;
import ua.com.shop.service.PhoneService;

public class PhoneValidator implements Validator {

	private final static Pattern REG1 = Pattern
			.compile("^([0-9]{1,17}\\.[0-9]{1,2})|([0-9]{1,17}\\,[0-9]{1,2})|([0-9]{1,17})$");
	private final static Pattern REG2 = Pattern.compile("([0-9]{1,9})");

	private PhoneService phoneService;

	public PhoneValidator(PhoneService phoneService) {
		this.phoneService = phoneService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return PhoneForm.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		PhoneForm form = (PhoneForm) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "model", "",
				"Can't be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "",
				"Can't be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "displayValue", "",
				"Can't be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "primaryCamera", "",
				"Can't be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "secondaryCamera",
				"", "Can't be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ram", "",
				"Can't be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "internal", "",
				"Can't be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "card", "",
				"Can't be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "numberOfSimCards",
				"", "Can't be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "battery", "",
				"Can't be empty");
		if (!REG1.matcher(form.getPrice()).matches()) {
			errors.rejectValue("price", "", "Error");
		}
		if (!REG1.matcher(form.getDisplayValue()).matches()) {
			errors.rejectValue("displayValue", "", "Error");
		}
		if (!REG1.matcher(form.getPrimaryCamera()).matches()) {
			errors.rejectValue("primaryCamera", "", "Error");
		}
		if (!REG1.matcher(form.getSecondaryCamera()).matches()) {
			errors.rejectValue("secondaryCamera", "", "Error");
		}
		if (!REG1.matcher(form.getRam()).matches()) {
			errors.rejectValue("ram", "", "Error");
		}
		if (!REG1.matcher(form.getInternal()).matches()) {
			errors.rejectValue("internal", "", "Error");
		}
		if (!REG1.matcher(form.getCard()).matches()) {
			errors.rejectValue("card", "", "Error");
		}
		if (!REG2.matcher(form.getNumberOfSimCards()).matches()) {
			errors.rejectValue("numberOfSimCards", "", "Error");
		}
		if (!REG2.matcher(form.getBattery()).matches()) {
			errors.rejectValue("battery", "", "Error");
		}

		if (errors.getFieldError("model") == null
				&& errors.getFieldError("price") == null
				&& errors.getFieldError("displayValue") == null
				&& errors.getFieldError("primaryCamera") == null
				&& errors.getFieldError("secondaryCamera") == null
				&& errors.getFieldError("ram") == null
				&& errors.getFieldError("internal") == null
				&& errors.getFieldError("card") == null
				&& errors.getFieldError("numberOfSimCards") == null
				&& errors.getFieldError("battery") == null) {
			if (phoneService.findUnique(form.getMaker(), form.getModel(),
					form.getPrice(), form.getDisplayValue(),
					form.getDisplayResolution(), form.getPrimaryCamera(),
					form.getSecondaryCamera(), form.getProcessor(),
					form.getRam(), form.getInternal(), form.getCard(),
					form.getNumberOfSimCards(), form.getOperatingSystem(),
					form.getBattery(), form.getColor()) != null) {
				errors.rejectValue("ifExist", "", "Already exist!");
			}
		}
	}
}
