package ua.com.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.shop.entity.Display;

public interface DisplayDao extends JpaRepository<Display, Integer> {

}
