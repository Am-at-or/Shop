package ua.com.shop.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.shop.dao.NumberOfCoresDao;
import ua.com.shop.entity.NumberOfCores;
import ua.com.shop.service.NumberOfCoresService;

@Service
public class NumberOfCoresServiceImpl implements NumberOfCoresService {

	@Autowired
	private NumberOfCoresDao numberOfCoresDao;

	@Override
	public void save(NumberOfCores numberOfCores) {
		numberOfCoresDao.save(numberOfCores);
	}

	@Override
	public NumberOfCores findOne(int id) {
		return numberOfCoresDao.findOne(id);
	}

	@Override
	public List<NumberOfCores> findAll() {
		return numberOfCoresDao.findAll();
	}

	@Override
	public void delete(int id) {
		numberOfCoresDao.delete(id);
	}

	@Override
	public void update(NumberOfCores numberOfCores) {
		numberOfCoresDao.save(numberOfCores);
	}

	@Override
	public NumberOfCores findByNumberOfCores(String cores) {
		return numberOfCoresDao.findByNumberOfCores(cores);
	}

}
