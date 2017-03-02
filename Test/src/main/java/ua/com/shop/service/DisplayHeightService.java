package ua.com.shop.service;

import java.util.List;

import ua.com.shop.dto.form.DisplayHeightForm;
import ua.com.shop.entity.DisplayHeight;

public interface DisplayHeightService {

	void save(DisplayHeightForm displayHeightForm);

	DisplayHeight findOne(int id);

	List<DisplayHeight> findAll();

	void delete(int id);

	void update(DisplayHeight displayHeight);

	DisplayHeightForm findForm(int id);

	DisplayHeight findUnique(String height);

}
