package ua.com.shop.service;

import java.util.List;

import ua.com.shop.dto.form.InternalMemoryForm;
import ua.com.shop.entity.InternalMemory;

public interface InternalMemoryService {

	void save(InternalMemoryForm internalMemoryForm);

	InternalMemory findOne(int id);

	List<InternalMemory> findAll();

	void delete(int id);

	void update(InternalMemory internalMemory);

	InternalMemory findUnique(String internal);

	InternalMemoryForm findForm(int id);

}
