package ua.com.shop.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ua.com.shop.dao.ProcessorMakerDao;
import ua.com.shop.dto.filter.SimpleFilter;
import ua.com.shop.entity.ProcessorMaker;
import ua.com.shop.service.ProcessorMakerService;
import ua.com.shop.specification.ProcessorMakerSpecification;

@Service
public class ProcessorMakerServiceImpl implements ProcessorMakerService {

	@Autowired
	private ProcessorMakerDao processorMakerDao;

	@Override
	public void save(ProcessorMaker processorMaker) {
		processorMakerDao.save(processorMaker);
	}

	@Override
	public ProcessorMaker findOne(int id) {
		return processorMakerDao.findOne(id);
	}

	@Override
	public List<ProcessorMaker> findAll() {
		return processorMakerDao.findAll();
	}

	@Override
	public void delete(int id) {
		processorMakerDao.delete(id);
	}

	@Override
	public void update(ProcessorMaker processorMaker) {
		processorMakerDao.save(processorMaker);
	}

	@Override
	public ProcessorMaker findByProcessorMaker(String maker) {
		return processorMakerDao.findByProcessorMaker(maker);
	}

	@Override
	public Page<ProcessorMaker> findAll(Pageable pageable, SimpleFilter filter) {
		return processorMakerDao.findAll(new ProcessorMakerSpecification(filter), pageable);
	}

}
