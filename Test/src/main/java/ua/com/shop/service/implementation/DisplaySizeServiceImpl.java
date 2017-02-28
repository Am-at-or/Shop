package ua.com.shop.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.shop.dao.DisplaySizeDao;
import ua.com.shop.entity.DisplaySize;
import ua.com.shop.service.DisplaySizeService;

@Service
public class DisplaySizeServiceImpl implements DisplaySizeService {

	@Autowired
	private DisplaySizeDao displaySizeDao;

	@Override
	public void save(DisplaySize displaySize) {
		displaySizeDao.save(displaySize);
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
	public DisplaySize findByDisplaySize(int size) {
		return displaySizeDao.findByDisplaySize(size);
	}

}
