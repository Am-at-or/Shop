package ua.com.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.shop.entity.Mark;

public interface MarkDao extends JpaRepository<Mark, Integer> {

}
