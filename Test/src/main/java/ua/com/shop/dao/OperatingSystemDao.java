package ua.com.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.com.shop.entity.OperatingSystem;

public interface OperatingSystemDao extends
		JpaRepository<OperatingSystem, Integer> {

	@Query("SELECT o FROM OperatingSystem o WHERE o.name.id = ?1 and o.version = ?2")
	OperatingSystem findUnique(int nameId, String version);

}
