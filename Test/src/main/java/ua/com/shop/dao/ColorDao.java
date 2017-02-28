package ua.com.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.com.shop.entity.Color;

public interface ColorDao extends JpaRepository<Color, Integer> {

	@Query("SELECT c FROM Color c WHERE c.color = ?1")
	Color findByColor(String color);

}
