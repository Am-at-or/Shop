package ua.com.shop.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.shop.dao.ProcessorMakerDao;
import ua.com.shop.entity.ProcessorMaker;
import ua.com.shop.service.ProcessorMakerService;

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

}
