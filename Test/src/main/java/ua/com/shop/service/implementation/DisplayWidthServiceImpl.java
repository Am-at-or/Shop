package ua.com.shop.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.shop.dao.DisplayWidthDao;
import ua.com.shop.dto.form.DisplayWidthForm;
import ua.com.shop.entity.DisplayWidth;
import ua.com.shop.service.DisplayWidthService;

@Service
public class DisplayWidthServiceImpl implements DisplayWidthService {

	@Autowired
	private DisplayWidthDao displayWidthDao;

	@Override
	public void save(DisplayWidthForm form) {
		DisplayWidth entity = new DisplayWidth();
		entity.setId(form.getId());
		entity.setWidth(Integer.valueOf(form.getWidth()));
		displayWidthDao.save(entity);
	}

	@Override
	public DisplayWidth findOne(int id) {
		return displayWidthDao.findOne(id);
	}

	@Override
	public List<DisplayWidth> findAll() {
		return displayWidthDao.findAll();
	}

	@Override
	public void delete(int id) {
		displayWidthDao.delete(id);
	}

	@Override
	public void update(DisplayWidth displayWidth) {
		displayWidthDao.save(displayWidth);
	}

	@Override
	public DisplayWidthForm findForm(int id) {
		DisplayWidthForm form = new DisplayWidthForm();
		DisplayWidth entity = displayWidthDao.findOne(id);
		form.setId(entity.getId());
		form.setWidth(String.valueOf(entity.getWidth()));
		return form;
	}

	@Override
	public DisplayWidth findUnique(String width) {
		return displayWidthDao.findUnique(Integer.valueOf(width));
	}

}
