package ua.com.shop.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.com.shop.dto.filter.DisplayFilter;
import ua.com.shop.entity.Display;
import ua.com.shop.entity.DisplayHeight;
import ua.com.shop.entity.DisplayValue;
import ua.com.shop.entity.DisplayTechnology;
import ua.com.shop.entity.DisplayWidth;

public interface DisplayService {

	void save(Display display);

	Display findOne(int id);

	List<Display> findAll();

	void delete(int id);

	void update(Display display);

	Display findUnique(DisplayValue displayValue, DisplayWidth displayWidth,
			DisplayHeight displayHeight, DisplayTechnology displayTechnology);

	Page<Display> findAll(Pageable pageable, DisplayFilter filter);

}
