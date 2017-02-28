package ua.com.shop.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.shop.entity.ProcessorMaker;
import ua.com.shop.service.ProcessorMakerService;

public class ProcessorMakerValidator implements Validator {

	private ProcessorMakerService processorMakerService;

	public ProcessorMakerValidator(ProcessorMakerService processorMakerService) {
		this.processorMakerService = processorMakerService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return ProcessorMaker.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ProcessorMaker processorMaker = (ProcessorMaker) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "maker", "",
				"Can't be empty");
		if (processorMakerService.findByProcessorMaker(processorMaker
				.getMaker()) != null) {
			errors.rejectValue("maker", "", "Already exist!");
		}
	}

}
