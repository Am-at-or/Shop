package ua.com.shop.service;

import java.util.List;

import ua.com.shop.entity.DisplaySize;

public interface DisplaySizeService {

	void save(DisplaySize displaySize);

	DisplaySize findOne(int id);

	List<DisplaySize> findAll();

	void delete(int id);

	void update(DisplaySize displaySize);

}
