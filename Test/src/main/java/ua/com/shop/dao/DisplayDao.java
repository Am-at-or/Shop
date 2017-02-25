package ua.com.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.com.shop.entity.Display;

public interface DisplayDao extends JpaRepository<Display, Integer> {

	@Query("SELECT d FROM Display d LEFT JOIN FETCH d.size LEFT JOIN FETCH d.width LEFT JOIN FETCH d.height LEFT JOIN FETCH d.technology WHERE d.id = ?1")
	Display findOne(int id);

}
