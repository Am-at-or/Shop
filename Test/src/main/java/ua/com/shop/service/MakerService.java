package ua.com.shop.service;

import java.util.List;

import ua.com.shop.entity.Maker;

public interface MakerService {

	void save(Maker maker);

	Maker findOne(int id);

	List<Maker> findAll();

	void delete(int id);

	void update(Maker maker);

}
