package ua.com.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import ua.com.shop.entity.DisplayResolution;

public interface DisplayResolutionDao extends
		JpaRepository<DisplayResolution, Integer>,
		JpaSpecificationExecutor<DisplayResolution> {

	@Query("SELECT d FROM DisplayResolution d WHERE d.width = ?1 and d.height = ?2")
	DisplayResolution findUnique(int width, int height);

}
