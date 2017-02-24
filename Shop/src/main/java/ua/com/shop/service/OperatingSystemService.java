package ua.com.shop.service;

import java.util.List;

import ua.com.shop.entity.OperatingSystem;

public interface OperatingSystemService {
	
	void save(OperatingSystem operatingSystem);

	OperatingSystem findOne(int id);

	List<OperatingSystem> findAll();

	void delete(int id);

	void update(OperatingSystem operatingSystem);

}
