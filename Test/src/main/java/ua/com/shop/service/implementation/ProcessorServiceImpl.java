package ua.com.shop.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.shop.dao.ProcessorDao;
import ua.com.shop.entity.Processor;
import ua.com.shop.service.ProcessorService;

@Service
public class ProcessorServiceImpl implements ProcessorService {

	@Autowired
	private ProcessorDao processorDao;

	@Override
	public void save(Processor processor) {
		processorDao.save(processor);
	}

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
}
