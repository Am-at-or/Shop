package ua.com.shop.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.shop.dao.OSNameDao;
import ua.com.shop.entity.OSName;
import ua.com.shop.service.OSNameService;

@Service
public class OSNameServiceImpl implements OSNameService {

	@Autowired
	private OSNameDao osNameDao;

	@Override
	public void save(OSName osName) {
		osNameDao.save(osName);
	}

	@Override
	public OSName findOne(int id) {
		return osNameDao.findOne(id);
	}

	@Override
	public List<OSName> findAll() {
		return osNameDao.findAll();
	}

	@Override
	public void delete(int id) {
		osNameDao.delete(id);

	}

	@Override
	public void update(OSName osName) {
		osNameDao.save(osName);
	}

	@Override
	public OSName findByName(String name) {
		return osNameDao.findByName(name);
	}

}
