package ua.com.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.com.shop.entity.DisplayTechnology;

public interface DisplayTechnologyDao extends
		JpaRepository<DisplayTechnology, Integer> {

	@Query("SELECT d FROM DisplayTechnology d WHERE d.technology = ?1")
	DisplayTechnology findByDisplayTechnology(String technology);

}
