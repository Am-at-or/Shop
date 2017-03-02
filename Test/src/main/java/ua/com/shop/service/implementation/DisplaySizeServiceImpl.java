package ua.com.shop.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.shop.dao.DisplaySizeDao;
import ua.com.shop.dto.form.DisplaySizeForm;
import ua.com.shop.entity.DisplaySize;
import ua.com.shop.service.DisplaySizeService;

@Service
public class DisplaySizeServiceImpl implements DisplaySizeService {

	@Autowired
	private DisplaySizeDao displaySizeDao;

	@Override
	public void save(DisplaySizeForm form) {
		DisplaySize entity = new DisplaySize();
		entity.setId(form.getId());
		entity.setSize(Double.valueOf(form.getSize()));
		displaySizeDao.save(entity);
	}

	@Override
	public DisplaySize findOne(int id) {
		return displaySizeDao.findOne(id);
	}

	@Override
	public List<DisplaySize> findAll() {
		return displaySizeDao.findAll();
	}

	@Override
	public void delete(int id) {
		displaySizeDao.delete(id);
	}

	@Override
	public void update(DisplaySize displaySize) {
		displaySizeDao.save(displaySize);
	}

	@Override
	public DisplaySizeForm findForm(int id) {
		DisplaySizeForm form = new DisplaySizeForm();
		DisplaySize entity = displaySizeDao.findOne(id);
		form.setId(entity.getId());
		form.setSize(String.valueOf(entity.getSize()));
		return form;
	}

	@Override
	public DisplaySize findUnique(String size) {
		return displaySizeDao.findUnique(Double.valueOf(size));
	}

}
