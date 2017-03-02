package ua.com.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.com.shop.entity.DisplayHeight;

public interface DisplayHeightDao extends JpaRepository<DisplayHeight, Integer> {

	@Query("SELECT d FROM DisplayHeight d WHERE d.height = ?1")
	DisplayHeight findUnique(int height);

}
