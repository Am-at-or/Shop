package ua.com.shop.validator;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.shop.dto.form.NumberOfCoresForm;
import ua.com.shop.service.NumberOfCoresService;

public class NumberOfCoresValidator implements Validator {

	private final static Pattern REG = Pattern.compile("([0-9]{1})");

	private NumberOfCoresService numberOfCoresService;

	public NumberOfCoresValidator(NumberOfCoresService numberOfCoresService) {
		this.numberOfCoresService = numberOfCoresService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return NumberOfCoresForm.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		NumberOfCoresForm form = (NumberOfCoresForm) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cores", "",
				"Can't be empty");
		if (!REG.matcher(String.valueOf(form.getCores())).matches()) {
			errors.rejectValue("cores", "", "Enter numbers [0-9]{1}!");
		}

		if (errors.getFieldError("cores") == null) {
			if (numberOfCoresService.findUnique(form.getCores()) != null) {
				errors.rejectValue("ifExist", "", "Already exist!");
			}
		}
	}

}