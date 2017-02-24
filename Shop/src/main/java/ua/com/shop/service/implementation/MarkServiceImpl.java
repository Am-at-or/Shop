package ua.com.shop.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.shop.dao.MarkDao;
import ua.com.shop.entity.Mark;
import ua.com.shop.service.MarkService;

@Service
public class MarkServiceImpl implements MarkService {

	@Autowired
	private MarkDao markDao;

	@Override
	public void save(Mark mark) {
		markDao.save(mark);
	}

	@Override
	public Mark findOne(int id) {
		return markDao.findOne(id);
	}

	@Override
	public List<Mark> findAll() {
		return markDao.findAll();
	}

	@Override
	public void delete(int id) {
		markDao.delete(id);
	}

	@Override
	public void update(Mark mark) {
		markDao.save(mark);
	}

}
