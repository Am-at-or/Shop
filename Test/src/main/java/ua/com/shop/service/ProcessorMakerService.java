package ua.com.shop.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.com.shop.dto.filter.SimpleFilter;
import ua.com.shop.entity.ProcessorMaker;

public interface ProcessorMakerService {

	void save(ProcessorMaker processorMaker);

	ProcessorMaker findOne(int id);

	List<ProcessorMaker> findAll();

	void delete(int id);

	void update(ProcessorMaker processorMaker);

	ProcessorMaker findByProcessorMaker(String maker);
	
	Page<ProcessorMaker> findAll(Pageable pageable, SimpleFilter filter);

}
