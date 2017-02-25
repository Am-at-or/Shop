package ua.com.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.shop.entity.OperatingSystem;

public interface OperatingSystemDao extends
		JpaRepository<OperatingSystem, Integer> {

}
