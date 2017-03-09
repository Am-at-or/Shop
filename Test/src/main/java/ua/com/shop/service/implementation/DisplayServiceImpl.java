package ua.com.shop.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ua.com.shop.dao.DisplayDao;
import ua.com.shop.dto.filter.DisplayFilter;
import ua.com.shop.entity.Display;
import ua.com.shop.entity.DisplayHeight;
import ua.com.shop.entity.DisplayTechnology;
import ua.com.shop.entity.DisplayValue;
import ua.com.shop.entity.DisplayWidth;
import ua.com.shop.service.DisplayService;
import ua.com.shop.specification.DisplaySpecification;

@Service
public class DisplayServiceImpl implements DisplayService {

	@Autowired
	private DisplayDao displayDao;

	@Override
	public void save(Display display) {
		displayDao.save(display);
	}

	@Override
	public Display findOne(int id) {
		return displayDao.findOne(id);
	}

	@Override
	public List<Display> findAll() {
		return displayDao.findAll();
	}

	@Override
	public void delete(int id) {
		displayDao.delete(id);
	}

	@Override
	public void update(Display display) {
		displayDao.save(display);
	}

	@Override
	public Display findUnique(DisplayValue displayValue,
			DisplayWidth displayWidth, DisplayHeight displayHeight,
			DisplayTechnology displayTechnology) {
		return displayDao.findUnique(displayValue.getId(),
				displayWidth.getId(), displayHeight.getId(),
				displayTechnology.getId());
	}

	@Override
	public Page<Display> findAll(Pageable pageable, DisplayFilter filter) {
		return displayDao.findAll(new DisplaySpecification(filter), pageable);
	}

}
