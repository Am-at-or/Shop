package ua.com.shop.service;

import java.util.List;

import ua.com.shop.entity.Rating;

public interface RatingService {

	void save(Rating rating);

	Rating findOne(int id);

	List<Rating> findAll();

	void delete(int id);

	void update(Rating rating);
	
	List<Rating> findByPhone (int id);

}
