package ua.com.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ua.com.shop.entity.OSName;

public interface OSNameDao extends JpaRepository<OSName, Integer>,
		JpaSpecificationExecutor<OSName> {

	OSName findByName(String name);

}
