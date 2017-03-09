package ua.com.shop.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import ua.com.shop.entity.Display;

public interface DisplayDao extends JpaRepository<Display, Integer>,
		JpaSpecificationExecutor<Display> {

	@Query("SELECT d FROM Display d LEFT JOIN FETCH d.value LEFT JOIN FETCH d.width LEFT JOIN FETCH d.height LEFT JOIN FETCH d.technology")
	List<Display> findAll();

	@Query("SELECT d FROM Display d LEFT JOIN FETCH d.value LEFT JOIN FETCH d.width LEFT JOIN FETCH d.height LEFT JOIN FETCH d.technology WHERE d.id = ?1")
	Display findOne(int id);

	@Query("SELECT d FROM Display d WHERE d.value.id = ?1 and d.width.id = ?2 and d.height.id = ?3 and d.technology.id = ?4")
	Display findUnique(int valueId, int widthId, int heightId, int technologyId);

}
