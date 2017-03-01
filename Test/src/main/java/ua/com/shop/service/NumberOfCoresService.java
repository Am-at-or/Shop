package ua.com.shop.service;

import java.util.List;

import ua.com.shop.entity.NumberOfCores;

public interface NumberOfCoresService {

	void save(NumberOfCores numberOfCores);

	NumberOfCores findOne(int id);

	List<NumberOfCores> findAll();

	void delete(int id);

	void update(NumberOfCores numberOfCores);

	NumberOfCores findByNumberOfCores(String cores);

}
