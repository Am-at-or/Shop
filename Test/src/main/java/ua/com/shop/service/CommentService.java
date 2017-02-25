package ua.com.shop.service;

import java.util.List;

import ua.com.shop.entity.Comment;

public interface CommentService {
	
	void save(Comment comment);

	Comment findOne(int id);

	List<Comment> findAll();

	void delete(int id);

	void update(Comment comment);

}
