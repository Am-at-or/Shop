package ua.com.shop.service;

import java.util.List;

import ua.com.shop.entity.Processor;

public interface ProcessorService {

	void save(Processor processor);

	Processor findOne(int id);

	List<Processor> findAll();

	void delete(int id);

	void update(Processor processor);

}
