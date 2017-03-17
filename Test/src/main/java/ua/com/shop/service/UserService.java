package ua.com.shop.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.com.shop.dto.filter.UserFilter;
import ua.com.shop.entity.User;

public interface UserService {

	void save(User user);

	User findOne(int id);

	List<User> findAll();

	void delete(int id);

	void update(User user);

	User findUnique(String login);

	Page<User> findAll(Pageable pageable, UserFilter filter);

}