package ua.com.shop.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ua.com.shop.dao.DisplayResolutionDao;
import ua.com.shop.dto.filter.DisplayResolutionFilter;
import ua.com.shop.dto.form.DisplayResolutionForm;
import ua.com.shop.entity.DisplayResolution;
import ua.com.shop.service.DisplayResolutionService;
import ua.com.shop.specification.DisplayResolutionSpecification;

@Service
public class DisplayResolutionServiceImpl implements DisplayResolutionService {

	@Autowired
	private DisplayResolutionDao displayDao;

	@Override
	public void save(DisplayResolutionForm form) {
		DisplayResolution entity = new DisplayResolution();
		entity.setId(form.getId());
		entity.setWidth(Integer.valueOf(form.getWidth()));
		entity.setHeight(Integer.valueOf(form.getHeight()));
		displayDao.save(entity);
	}

	@Override
	public DisplayResolution findOne(int id) {
		return displayDao.findOne(id);
	}

	@Override
	public List<DisplayResolution> findAll() {
		return displayDao.findAll();
	}

	@Override
	public void delete(int id) {
		displayDao.delete(id);
	}

	@Override
	public void update(DisplayResolution display) {
		displayDao.save(display);
	}

	@Override
	public DisplayResolutionForm findForm(int id) {
		DisplayResolutionForm form = new DisplayResolutionForm();
		DisplayResolution entity = displayDao.findOne(id);
		form.setId(entity.getId());
		form.setWidth(String.valueOf(entity.getWidth()));
		form.setHeight(String.valueOf(entity.getHeight()));
		return form;
	}

	@Override
	public DisplayResolution findUnique(String width, String height) {
		return displayDao.findUnique(Integer.valueOf(width),
				Integer.valueOf(height));
	}

	@Override
	public Page<DisplayResolution> findAll(Pageable pageable,
			DisplayResolutionFilter filter) {
		return displayDao.findAll(new DisplayResolutionSpecification(filter),
				pageable);
	}

}
