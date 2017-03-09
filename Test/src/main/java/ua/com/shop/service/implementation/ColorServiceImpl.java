package ua.com.shop.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ua.com.shop.dao.ColorDao;
import ua.com.shop.dto.filter.SimpleFilter;
import ua.com.shop.entity.Color;
import ua.com.shop.service.ColorService;
import ua.com.shop.specification.ColorSpecification;

@Service
public class ColorServiceImpl implements ColorService {

	@Autowired
	private ColorDao colorDao;

	@Override
	public void save(Color color) {
		colorDao.save(color);
	}

	@Override
	public Color findOne(int id) {
		return colorDao.findOne(id);
	}

	@Override
	public List<Color> findAll() {
		return colorDao.findAll();
	}

	@Override
	public void delete(int id) {
		colorDao.delete(id);
	}

	@Override
	public void update(Color color) {
		colorDao.save(color);
	}

	@Override
	public Color findByColor(String color) {
		return colorDao.findByColor(color);
	}

	@Override
	public Page<Color> findAll(Pageable pageable, SimpleFilter filter) {
		return colorDao.findAll(new ColorSpecification(filter), pageable);
	}

}
