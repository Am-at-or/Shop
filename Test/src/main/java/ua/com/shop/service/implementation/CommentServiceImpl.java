package ua.com.shop.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.shop.dao.CommentDao;
import ua.com.shop.entity.Comment;
import ua.com.shop.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentDao commentDao;

	@Override
	public void save(Comment comment) {
		commentDao.save(comment);
	}

	@Override
	public Comment findOne(int id) {
		return commentDao.findOne(id);
	}

	@Override
	public List<Comment> findAll() {
		return commentDao.findAll();
	}

	@Override
	public void delete(int id) {
		commentDao.delete(id);
	}

	@Override
	public void update(Comment comment) {
		commentDao.save(comment);
	}
}
