package ua.com.shop.service;

import java.util.List;

import ua.com.shop.dto.form.DisplayValueForm;
import ua.com.shop.entity.DisplayValue;

public interface DisplayValueService {

	void save(DisplayValueForm displayValueForm);

	DisplayValue findOne(int id);

	List<DisplayValue> findAll();

	void delete(int id);

	void update(DisplayValue displayValue);

	DisplayValueForm findForm(int id);

	DisplayValue findUnique(String value);

}
