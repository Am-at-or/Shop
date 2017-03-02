package ua.com.shop.service;

import java.util.List;

import ua.com.shop.dto.form.CardMemoryForm;
import ua.com.shop.entity.CardMemory;

public interface CardMemoryService {

	void save(CardMemoryForm cardMemoryForm);

	CardMemory findOne(int id);

	List<CardMemory> findAll();

	void delete(int id);

	void update(CardMemory cardMemory);

	CardMemory findUnique(String card);

	CardMemoryForm findForm(int id);

}
