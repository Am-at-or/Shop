package ua.com.shop.validator;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.shop.dto.form.ProcessorForm;
import ua.com.shop.service.ProcessorService;

public class ProcessorValidator implements Validator {

	private final static Pattern REG = Pattern
			.compile("([0-9]{1}\\.[0-9]{1,2})|([0-9]{1}\\,[0-9]{1,2})|([0-9]{1})");

	private ProcessorService processorService;

	public ProcessorValidator(ProcessorService processorService) {
		this.processorService = processorService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return ProcessorForm.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ProcessorForm form = (ProcessorForm) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "model", "",
				"Can't be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "frequency", "",
				"Can't be empty");
		if (!REG.matcher(form.getFrequency()).matches()) {
			errors.rejectValue("frequency", "",
					"Enter numbers [0-9]{1}\\.[0-9]{1,2})!");
		}
		if (errors.getFieldError("model") == null
				&& errors.getFieldError("frequency") == null) {
			if (processorService.findUnique(form.getMaker(), form.getModel(),
					form.getFrequency(), form.getNumberOfCores()) != null) {
				errors.rejectValue("ifExist", "", "Already exist!");
			}
		}
	}

}
