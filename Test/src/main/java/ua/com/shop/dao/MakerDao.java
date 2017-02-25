package ua.com.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.shop.entity.Maker;

public interface MakerDao extends JpaRepository<Maker, Integer> {
	
	
}
