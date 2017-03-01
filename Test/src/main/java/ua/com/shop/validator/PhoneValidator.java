package ua.com.shop.validator;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.shop.dto.form.PhoneForm;
import ua.com.shop.service.PhoneService;

public class PhoneValidator implements Validator {

	private final static Pattern REG1 = Pattern.compile("([0-9]{1,9})");

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
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "primaryCamera", "",
				"Can't be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ram", "",
				"Can't be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "internal", "",
				"Can't be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "numberOfSimCards",
				"", "Can't be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "battery", "",
				"Can't be empty");

		if (!REG1.matcher(String.valueOf(form.getPrice())).matches()) {
			errors.rejectValue("price", "", "Enter text [0-9]{1,9}!");
		}
		if (!REG1.matcher(String.valueOf(form.getRam())).matches()) {
			errors.rejectValue("primaryCamera", "", "Enter text [0-9]{1,9}!");
		}
		if (!REG1.matcher(String.valueOf(form.getPrimaryCamera())).matches()) {
			errors.rejectValue("ram", "", "Enter text [0-9]{1,9}!");
		}
		if (!REG1.matcher(String.valueOf(form.getInternal())).matches()) {
			errors.rejectValue("internal", "", "Enter text [0-9]{1,9}!");
		}
		if (!REG1.matcher(String.valueOf(form.getNumberOfSimCards())).matches()) {
			errors.rejectValue("numberOfSimCards", "", "Enter text [0-9]{1,9}!");
		}
		if (!REG1.matcher(String.valueOf(form.getBattery())).matches()) {
			errors.rejectValue("battery", "", "Enter text [0-9]{1,9}!");
		}

		if (errors.getFieldError("model") == null
				&& errors.getFieldError("price") == null
				&& errors.getFieldError("primaryCamera") == null
				&& errors.getFieldError("ram") == null
				&& errors.getFieldError("internal") == null
				&& errors.getFieldError("numberOfSimCards") == null
				&& errors.getFieldError("battery") == null) {
			if (phoneService.findUnique(form.getMaker(), form.getModel(),
					form.getPrice(), form.getDisplay(),
					form.getPrimaryCamera(), form.getSecondaryCamera(),
					form.getProcessor(), form.getRam(), form.getInternal(),
					form.getCard(), form.getNumberOfSimCards(),
					form.getOperatingSystem(), form.getBattery(),
					form.getColor()) != null) {
				errors.rejectValue("model", "", "Already exist!");
			}
		}
	}
}
