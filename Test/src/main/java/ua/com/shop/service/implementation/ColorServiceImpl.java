package ua.com.shop.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.shop.dao.ColorDao;
import ua.com.shop.entity.Color;
import ua.com.shop.service.ColorService;

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

}
