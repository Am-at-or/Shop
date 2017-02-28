package ua.com.shop.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.shop.entity.Maker;
import ua.com.shop.service.MakerService;

public class MakerValidator implements Validator {

	private MakerService makerService;

	public MakerValidator(MakerService makerService) {
		this.makerService = makerService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return Maker.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Maker maker = (Maker) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "",
				"Can't be empty");
		if (makerService.findByMaker(maker.getName()) != null) {
			errors.rejectValue("name", "", "Already exist!");
		}
	}

}
