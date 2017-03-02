package ua.com.shop.validator;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.shop.dto.form.RamForm;
import ua.com.shop.service.RamService;

public class RamValidator implements Validator {

	private final static Pattern REG = Pattern.compile("([0-9]{1})");

	private RamService ramService;

	public RamValidator(RamService ramService) {
		this.ramService = ramService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return RamForm.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		RamForm form = (RamForm) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ram", "",
				"Can't be empty");
		if (!REG.matcher(String.valueOf(form.getRam())).matches()) {
			errors.rejectValue("ram", "", "Enter numbers [0-9]{1}!");
		}

		if (errors.getFieldError("ram") == null) {
			if (ramService.findUnique(form.getRam()) != null) {
				errors.rejectValue("ifExist", "", "Already exist!");
			}
		}
	}

}