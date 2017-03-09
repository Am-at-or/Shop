package ua.com.shop.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.com.shop.dto.filter.SimpleFilter;
import ua.com.shop.entity.Color;

public interface ColorService {

	void save(Color color);

	Color findOne(int id);

	List<Color> findAll();

	void delete(int id);

	void update(Color color);

	Color findByColor(String color);

	Page<Color> findAll(Pageable pageable, SimpleFilter filter);

}
