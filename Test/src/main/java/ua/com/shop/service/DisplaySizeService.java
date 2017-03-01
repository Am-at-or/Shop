package ua.com.shop.service;

import java.util.List;

import ua.com.shop.dto.form.DisplaySizeForm;
import ua.com.shop.entity.DisplaySize;

public interface DisplaySizeService {

	void save(DisplaySizeForm displaySizeForm);

	DisplaySize findOne(int id);

	List<DisplaySize> findAll();

	void delete(int id);

	void update(DisplaySize displaySize);

	DisplaySizeForm findForm(int id);

	DisplaySize findUnique(String size);

}
