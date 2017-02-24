package ua.com.shop.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.shop.dao.DisplayHeightDao;
import ua.com.shop.entity.DisplayHeight;
import ua.com.shop.service.DisplayHeightService;

@Service
public class DisplayHeightServiceImpl implements DisplayHeightService {

	@Autowired
	private DisplayHeightDao displayHeightDao;

	@Override
	public void save(DisplayHeight displayHeight) {
		displayHeightDao.save(displayHeight);
	}

	@Override
	public DisplayHeight findOne(int id) {
		return displayHeightDao.findOne(id);
	}

	@Override
	public List<DisplayHeight> findAll() {
		return displayHeightDao.findAll();
	}

	@Override
	public void delete(int id) {
		displayHeightDao.delete(id);
	}

	@Override
	public void update(DisplayHeight displayHeight) {
		displayHeightDao.save(displayHeight);
	}

}
