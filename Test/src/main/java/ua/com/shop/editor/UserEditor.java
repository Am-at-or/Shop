package ua.com.shop.editor;

import java.beans.PropertyEditorSupport;

import ua.com.shop.entity.User;
import ua.com.shop.service.UserService;

public class UserEditor extends PropertyEditorSupport {

	private final UserService userService;

	public UserEditor(UserService userService) {
		this.userService = userService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		User user = userService.findOne(Integer.valueOf(text));
		setValue(user);
	}

}
