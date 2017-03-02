package ua.com.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.com.shop.entity.DisplayWidth;

public interface DisplayWidthDao extends JpaRepository<DisplayWidth, Integer> {

	@Query("SELECT d FROM DisplayWidth d WHERE d.width = ?1")
	DisplayWidth findUnique(int width);

}
