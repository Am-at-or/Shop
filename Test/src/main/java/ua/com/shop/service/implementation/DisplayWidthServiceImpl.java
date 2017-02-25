package ua.com.shop.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.shop.dao.DisplayWidthDao;
import ua.com.shop.entity.DisplayWidth;
import ua.com.shop.service.DisplayWidthService;

@Service
public class DisplayWidthServiceImpl implements DisplayWidthService {

	@Autowired
	private DisplayWidthDao displayWidthDao;

	@Override
	public void save(DisplayWidth displayWidth) {
		displayWidthDao.save(displayWidth);
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

}
