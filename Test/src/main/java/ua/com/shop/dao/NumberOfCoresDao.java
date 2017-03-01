package ua.com.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.com.shop.entity.NumberOfCores;

public interface NumberOfCoresDao extends JpaRepository<NumberOfCores, Integer> {

	@Query("SELECT n FROM NumberOfCores n WHERE n.cores = ?1")
	NumberOfCores findByNumberOfCores(String cores);

}
