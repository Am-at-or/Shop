package ua.com.shop.service;

import java.util.List;

import ua.com.shop.entity.ProcessorMaker;

public interface ProcessorMakerService {

	void save(ProcessorMaker processorMaker);

	ProcessorMaker findOne(int id);

	List<ProcessorMaker> findAll();

	void delete(int id);

	void update(ProcessorMaker processorMaker);

	ProcessorMaker findByProcessorMaker(String maker);

}
