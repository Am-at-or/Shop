package ua.com.shop.service;

import java.util.List;

import ua.com.shop.dto.form.NumberOfCoresForm;
import ua.com.shop.entity.NumberOfCores;

public interface NumberOfCoresService {

	void save(NumberOfCoresForm numberOfCoresForm);

	NumberOfCores findOne(int id);

	List<NumberOfCores> findAll();

	void delete(int id);

	void update(NumberOfCores numberOfCores);

	NumberOfCores findUnique(String cores);

	NumberOfCoresForm findForm(int id);

}
