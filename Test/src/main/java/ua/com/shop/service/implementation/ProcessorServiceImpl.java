package ua.com.shop.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ua.com.shop.dao.ProcessorDao;
import ua.com.shop.dto.filter.ProcessorFilter;
import ua.com.shop.dto.form.ProcessorForm;
import ua.com.shop.entity.Processor;
import ua.com.shop.entity.ProcessorMaker;
import ua.com.shop.service.ProcessorService;
import ua.com.shop.specification.ProcessorSpecification;

@Service
public class ProcessorServiceImpl implements ProcessorService {

	@Autowired
	private ProcessorDao processorDao;

	@Override
	public Processor findOne(int id) {
		return processorDao.findOne(id);
	}

	@Override
	public List<Processor> findAll() {
		return processorDao.findAll();
	}

	@Override
	public void delete(int id) {
		processorDao.delete(id);
	}

	@Override
	public void update(Processor processor) {
		processorDao.save(processor);
	}

	@Override
	public Processor findUnique(ProcessorMaker processorMakerId, String model,
			String frequency, String numberOfCoresId) {
		return processorDao.findUnique(processorMakerId.getId(), model,
				Double.valueOf(frequency.replace(",", ".")),
				Integer.valueOf(numberOfCoresId));
	}

	@Override
	public ProcessorForm findForm(int id) {
		ProcessorForm form = new ProcessorForm();
		Processor entity = processorDao.findOne(id);
		form.setId(entity.getId());
		form.setMaker(entity.getMaker());
		form.setModel(entity.getModel());
		form.setFrequency(String.valueOf(entity.getFrequency()));
		form.setNumberOfCores(String.valueOf(entity.getNumberOfCores()));
		return form;
	}

	@Override
	public void save(ProcessorForm form) {
		Processor entity = new Processor();
		entity.setId(form.getId());
		entity.setMaker(form.getMaker());
		entity.setModel(form.getModel());
		entity.setFrequency(Double.valueOf(form.getFrequency()
				.replace(",", ".")));
		entity.setNumberOfCores(Integer.valueOf(form.getNumberOfCores()));
		processorDao.save(entity);
	}

	@Override
	public Page<Processor> findAll(Pageable pageable, ProcessorFilter filter) {
		return processorDao.findAll(new ProcessorSpecification(filter),
				pageable);
	}

}
