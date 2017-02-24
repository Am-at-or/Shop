package ua.com.shop.service;

import java.util.List;

import ua.com.shop.entity.DisplayHeight;

public interface DisplayHeightService {

	void save(DisplayHeight displayHeight);

	DisplayHeight findOne(int id);

	List<DisplayHeight> findAll();

	void delete(int id);

	void update(DisplayHeight displayHeight);

}
