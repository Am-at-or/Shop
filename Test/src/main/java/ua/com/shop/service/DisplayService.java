package ua.com.shop.service;

import java.util.List;

import ua.com.shop.entity.Display;
import ua.com.shop.entity.DisplayHeight;
import ua.com.shop.entity.DisplaySize;
import ua.com.shop.entity.DisplayTechnology;
import ua.com.shop.entity.DisplayWidth;

public interface DisplayService {

	void save(Display display);

	Display findOne(int id);

	List<Display> findAll();

	void delete(int id);

	void update(Display display);

	Display findUnique(DisplaySize displaySize, DisplayWidth displayWidth,
			DisplayHeight displayHeight, DisplayTechnology displayTechnology);

}
