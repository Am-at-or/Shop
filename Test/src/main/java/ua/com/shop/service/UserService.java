package ua.com.shop.service;

import ua.com.shop.entity.User;

public interface UserService {
	
	void save(User user);

	User findOne(int id);

}