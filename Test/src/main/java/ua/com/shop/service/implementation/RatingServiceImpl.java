package ua.com.shop.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.shop.dao.RatingDao;
import ua.com.shop.entity.Rating;
import ua.com.shop.service.RatingService;

@Service
public class RatingServiceImpl implements RatingService {

	@Autowired
	private RatingDao ratingDao;

	@Override
	public void save(Rating rating) {
		ratingDao.save(rating);
	}

	@Override
	public Rating findOne(int id) {
		return ratingDao.findOne(id);
	}

	@Override
	public List<Rating> findAll() {
		return ratingDao.findAll();
	}

	@Override
	public void delete(int id) {
		ratingDao.delete(id);
	}

	@Override
	public void update(Rating rating) {
		ratingDao.save(rating);
	}

	@Override
	public List<Rating> findByPhone(int id) {
		
		return null;
	}
}
