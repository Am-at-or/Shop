package ua.com.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.com.shop.entity.DisplaySize;

public interface DisplaySizeDao extends JpaRepository<DisplaySize, Integer> {
	
	@Query("SELECT d FROM DisplaySize d WHERE d.size = ?1")
	DisplaySize findByDisplaySize(int size);

}
