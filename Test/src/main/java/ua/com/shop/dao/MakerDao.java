package ua.com.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import ua.com.shop.entity.Maker;

public interface MakerDao extends JpaRepository<Maker, Integer>,
		JpaSpecificationExecutor<Maker> {

	@Query("SELECT m FROM Maker m WHERE m.name = ?1")
	Maker findByMaker(String name);

}
