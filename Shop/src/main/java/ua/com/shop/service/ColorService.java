package ua.com.shop.service;

import java.util.List;

import ua.com.shop.entity.Color;

public interface ColorService {

	void save(Color color);

	Color findOne(int id);

	List<Color> findAll();

	void delete(int id);

	void update(Color color);

}
