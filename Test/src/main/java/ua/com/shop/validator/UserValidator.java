package ua.com.shop.validator;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.shop.entity.User;
import ua.com.shop.service.UserService;

public class UserValidator implements Validator {

	private final static Pattern REG1 = Pattern
			.compile("\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*\\.\\w{2,4}");
	private final static Pattern REG2 = Pattern.compile("([0-9]{10})|()");
	private final static Pattern REG3 = Pattern.compile("([a-zA-Z0-9]{0,20})");
	private final static Pattern REG4 = Pattern.compile("([a-zA-Z]{0,20})");

	private UserService userService;

	public UserValidator(UserService userService) {
		this.userService = userService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user = (User) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "",
				"Can't be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "",
				"Can't be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "",
				"Can't be empty");
		try {
			if (!REG1.matcher(user.getEmail()).matches()) {
				errors.rejectValue("email", "", "Error");
			}
			if (!REG3.matcher(user.getLogin()).matches()) {
				errors.rejectValue("login", "", "Error");
			}
			if (!REG2.matcher(user.getPhoneNumber()).matches()) {
				errors.rejectValue("phoneNumber", "", "Error");
			}
			if (!REG4.matcher(user.getFirstName()).matches()) {
				errors.rejectValue("firstName", "", "Error");
			}
			if (!REG4.matcher(user.getLastName()).matches()) {
				errors.rejectValue("lastName", "", "Error");
			}
		
		if (errors.getFieldError("email") == null
				&& errors.getFieldError("login") == null
				&& errors.getFieldError("password") == null
				&& errors.getFieldError("phoneNumber") == null
				&& errors.getFieldError("firstName") == null
				&& errors.getFieldError("lastName") == null) {
			User user2 = userService.findUnique(user.getLogin());
			if (user2 != null & user2.getId() != user.getId()) {
				errors.rejectValue("phoneNumber", "", "Already exist!");
			}
		}
		} catch (NullPointerException e) {
			System.out.println("Помилка");
		}
	}
}
