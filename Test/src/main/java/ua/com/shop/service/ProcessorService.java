package ua.com.shop.service;

import java.util.List;

import ua.com.shop.dto.form.ProcessorForm;
import ua.com.shop.entity.NumberOfCores;
import ua.com.shop.entity.Processor;
import ua.com.shop.entity.ProcessorMaker;

public interface ProcessorService {

	void save(ProcessorForm form);

	Processor findOne(int id);

	List<Processor> findAll();

	void delete(int id);

	void update(Processor processor);

	ProcessorForm findForm(int id);

	Processor findUnique(ProcessorMaker makerId, String model,
			String frequency, NumberOfCores numberOfCoresId);

}
