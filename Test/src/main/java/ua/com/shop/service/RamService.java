package ua.com.shop.service;

import java.util.List;

import ua.com.shop.dto.form.RamForm;
import ua.com.shop.entity.Ram;

public interface RamService {

	void save(RamForm ramForm);

	Ram findOne(int id);

	List<Ram> findAll();

	void delete(int id);

	void update(Ram ram);

	Ram findUnique(String ram);

	RamForm findForm(int id);

}
