package ua.com.shop.service;

import java.util.List;

import ua.com.shop.entity.DisplayTechnology;

public interface DisplayTechnologyService {

	void save(DisplayTechnology displayTechnology);

	DisplayTechnology findOne(int id);

	List<DisplayTechnology> findAll();

	void delete(int id);

	void update(DisplayTechnology displayTechnology);

	DisplayTechnology findByDisplayTechnology(String technology);

}
