package ua.com.shop.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.shop.dao.NumberOfCoresDao;
import ua.com.shop.dto.form.NumberOfCoresForm;
import ua.com.shop.entity.NumberOfCores;
import ua.com.shop.service.NumberOfCoresService;

@Service
public class NumberOfCoresServiceImpl implements NumberOfCoresService {

	@Autowired
	private NumberOfCoresDao numberOfCoresDao;

	@Override
	public void save(NumberOfCoresForm form) {
		NumberOfCores entity = new NumberOfCores();
		entity.setId(form.getId());
		entity.setCores(Integer.valueOf(form.getCores()));
		numberOfCoresDao.save(entity);
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
	public NumberOfCoresForm findForm(int id) {
		NumberOfCoresForm form = new NumberOfCoresForm();
		NumberOfCores entity = numberOfCoresDao.findOne(id);
		form.setId(entity.getId());
		form.setCores(String.valueOf(entity.getCores()));
		return form;
	}

	@Override
	public NumberOfCores findUnique(String cores) {
		return numberOfCoresDao.findUnique(Integer.valueOf(cores));
	}

}