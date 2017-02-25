package ua.com.shop.service;

import java.util.List;

import ua.com.shop.entity.Mark;

public interface MarkService {

	void save(Mark mark);

	Mark findOne(int id);

	List<Mark> findAll();

	void delete(int id);

	void update(Mark mark);

}
