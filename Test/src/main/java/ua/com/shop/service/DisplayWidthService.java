package ua.com.shop.service;

import java.util.List;

import ua.com.shop.dto.form.DisplayWidthForm;
import ua.com.shop.entity.DisplayWidth;

public interface DisplayWidthService {

	void save(DisplayWidthForm displayWidth);

	DisplayWidth findOne(int id);

	List<DisplayWidth> findAll();

	void delete(int id);

	void update(DisplayWidth displayWidth);

	DisplayWidthForm findForm(int id);

	DisplayWidth findUnique(String width);

}
