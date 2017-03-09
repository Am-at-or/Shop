package ua.com.shop.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.com.shop.dto.filter.SimpleFilter;
import ua.com.shop.entity.Maker;

public interface MakerService {

	void save(Maker maker);

	Maker findOne(int id);

	List<Maker> findAll();

	void delete(int id);

	void update(Maker maker);
	
	Maker findByMaker(String name);
	
	Page<Maker> findAll(Pageable pageable, SimpleFilter filter);

}
