package ua.com.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.shop.entity.Comment;

public interface CommentDao extends JpaRepository<Comment, Integer> {

}
