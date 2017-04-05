package ua.com.shop.service;

import java.util.List;

import ua.com.shop.entity.People;

public interface PeopleService {
	
	List<People> findAll();
	People save (People people);
	void delete(int id);
	People findOne(int id);

}
