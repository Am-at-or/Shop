package ua.com.shop.editor;

import java.beans.PropertyEditorSupport;

import ua.com.shop.entity.Phone;
import ua.com.shop.service.PhoneService;

public class PhoneEditor extends PropertyEditorSupport {

	private final PhoneService phoneService;

	public PhoneEditor(PhoneService phoneService) {
		this.phoneService = phoneService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Phone phone = phoneService.findOne(Integer.valueOf(text));
		setValue(phone);
	}

}
