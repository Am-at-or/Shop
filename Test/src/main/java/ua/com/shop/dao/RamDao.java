package ua.com.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.com.shop.entity.Ram;

public interface RamDao extends JpaRepository<Ram, Integer> {

	@Query("SELECT r FROM Ram r WHERE r.ram = ?1")
	Ram findUnique(int ram);

}
