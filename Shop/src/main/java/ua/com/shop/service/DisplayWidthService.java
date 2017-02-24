package ua.com.shop.service;

import java.util.List;

import ua.com.shop.entity.DisplayWidth;

public interface DisplayWidthService {

	void save(DisplayWidth displayWidth);

	DisplayWidth findOne(int id);

	List<DisplayWidth> findAll();

	void delete(int id);

	void update(DisplayWidth displayWidth);

}
