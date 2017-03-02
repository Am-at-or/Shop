package ua.com.shop.validator;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.shop.dto.form.InternalMemoryForm;
import ua.com.shop.service.InternalMemoryService;

public class InternalMemoryValidator implements Validator {

	private final static Pattern REG = Pattern.compile("([0-9]{1})");

	private InternalMemoryService internalMemoryService;

	public InternalMemoryValidator(InternalMemoryService internalMemoryService) {
		this.internalMemoryService = internalMemoryService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return InternalMemoryForm.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		InternalMemoryForm form = (InternalMemoryForm) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "internal", "",
				"Can't be empty");
		if (!REG.matcher(String.valueOf(form.getInternal())).matches()) {
			errors.rejectValue("internal", "", "Enter numbers [0-9]{1}!");
		}

		if (errors.getFieldError("internal") == null) {
			if (internalMemoryService.findUnique(form.getInternal()) != null) {
				errors.rejectValue("ifExist", "", "Already exist!");
			}
		}
	}

}