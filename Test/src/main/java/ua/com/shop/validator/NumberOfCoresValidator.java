package ua.com.shop.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.shop.entity.NumberOfCores;
import ua.com.shop.service.NumberOfCoresService;

public class NumberOfCoresValidator implements Validator {

	private NumberOfCoresService numberOfCoresService;

	public NumberOfCoresValidator(NumberOfCoresService numberOfCoresService) {
		this.numberOfCoresService = numberOfCoresService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return NumberOfCores.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		NumberOfCores numberOfCores = (NumberOfCores) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cores", "",
				"Can't be empty");
		if (numberOfCoresService.findByNumberOfCores(numberOfCores.getCores()) != null) {
			errors.rejectValue("cores", "", "Already exist!");
		}
	}

}
