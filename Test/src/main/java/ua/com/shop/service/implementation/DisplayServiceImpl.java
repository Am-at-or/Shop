package ua.com.shop.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.shop.dao.DisplayDao;
import ua.com.shop.entity.Display;
import ua.com.shop.entity.DisplayHeight;
import ua.com.shop.entity.DisplaySize;
import ua.com.shop.entity.DisplayTechnology;
import ua.com.shop.entity.DisplayWidth;
import ua.com.shop.service.DisplayService;

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
	public Display findUnique(DisplaySize displaySize,
			DisplayWidth displayWidth, DisplayHeight displayHeight,
			DisplayTechnology displayTechnology) {
		return displayDao.findUnique(displaySize.getId(), displayWidth.getId(),
				displayHeight.getId(), displayTechnology.getId());
	}
}
