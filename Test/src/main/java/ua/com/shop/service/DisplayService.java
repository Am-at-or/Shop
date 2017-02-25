package ua.com.shop.service;

import java.util.List;

import ua.com.shop.entity.Display;

public interface DisplayService {

	void save(Display display);

	Display findOne(int id);

	List<Display> findAll();

	void delete(int id);

	void update(Display display);

}
