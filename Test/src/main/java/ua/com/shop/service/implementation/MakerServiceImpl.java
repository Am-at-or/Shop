package ua.com.shop.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.shop.dao.MakerDao;
import ua.com.shop.entity.Maker;
import ua.com.shop.service.MakerService;

@Service
public class MakerServiceImpl implements MakerService {

	@Autowired
	private MakerDao makerDao;

	@Override
	public void save(Maker maker) {
		makerDao.save(maker);
	}

	@Override
	public Maker findOne(int id) {
		return makerDao.findOne(id);
	}

	@Override
	public List<Maker> findAll() {
		return makerDao.findAll();
	}

	@Override
	public void delete(int id) {
		makerDao.delete(id);
	}

	@Override
	public void update(Maker maker) {
		makerDao.save(maker);
	}

	@Override
	public Maker findByMaker(String name) {
		return makerDao.findByMaker(name);
	}

}
