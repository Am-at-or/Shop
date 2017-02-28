package ua.com.shop.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.shop.dao.DisplayTechnologyDao;
import ua.com.shop.entity.DisplayTechnology;
import ua.com.shop.service.DisplayTechnologyService;

@Service
public class DisplayTechnologyServiceImpl implements DisplayTechnologyService {

	@Autowired
	private DisplayTechnologyDao displayTechnologyDao;

	@Override
	public void save(DisplayTechnology displayTechnology) {
		displayTechnologyDao.save(displayTechnology);
	}

	@Override
	public DisplayTechnology findOne(int id) {
		return displayTechnologyDao.findOne(id);
	}

	@Override
	public List<DisplayTechnology> findAll() {
		return displayTechnologyDao.findAll();
	}

	@Override
	public void delete(int id) {
		displayTechnologyDao.delete(id);
	}

	@Override
	public void update(DisplayTechnology displayTechnology) {
		displayTechnologyDao.save(displayTechnology);
	}

	@Override
	public DisplayTechnology findByDisplayTechnology(String technology) {
		return displayTechnologyDao.findByDisplayTechnology(technology);
	}

}
