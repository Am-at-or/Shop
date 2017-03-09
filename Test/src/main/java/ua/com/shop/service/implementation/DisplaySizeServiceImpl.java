package ua.com.shop.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.shop.dao.DisplayValueDao;
import ua.com.shop.dto.form.DisplayValueForm;
import ua.com.shop.entity.DisplayValue;
import ua.com.shop.service.DisplayValueService;

@Service
public class DisplaySizeServiceImpl implements DisplayValueService {

	@Autowired
	private DisplayValueDao displayValueDao;

	@Override
	public void save(DisplayValueForm form) {
		DisplayValue entity = new DisplayValue();
		entity.setId(form.getId());
		entity.setValue(Double.valueOf(form.getValue()));
		displayValueDao.save(entity);
	}

	@Override
	public DisplayValue findOne(int id) {
		return displayValueDao.findOne(id);
	}

	@Override
	public List<DisplayValue> findAll() {
		return displayValueDao.findAll();
	}

	@Override
	public void delete(int id) {
		displayValueDao.delete(id);
	}

	@Override
	public void update(DisplayValue displayValue) {
		displayValueDao.save(displayValue);
	}

	@Override
	public DisplayValueForm findForm(int id) {
		DisplayValueForm form = new DisplayValueForm();
		DisplayValue entity = displayValueDao.findOne(id);
		form.setId(entity.getId());
		form.setValue(String.valueOf(entity.getValue()));
		return form;
	}

	@Override
	public DisplayValue findUnique(String value) {
		return displayValueDao.findUnique(Double.valueOf(value));
	}

}
