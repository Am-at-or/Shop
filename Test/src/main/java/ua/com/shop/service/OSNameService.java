package ua.com.shop.service;

import java.util.List;

import ua.com.shop.entity.OSName;

public interface OSNameService {

	void save(OSName osName);

	OSName findOne(int id);

	List<OSName> findAll();

	void delete(int id);

	void update(OSName osName);

	OSName findByName(String name);

}
