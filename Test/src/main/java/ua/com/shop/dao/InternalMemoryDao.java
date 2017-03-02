package ua.com.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.com.shop.entity.InternalMemory;

public interface InternalMemoryDao extends
		JpaRepository<InternalMemory, Integer> {

	@Query("SELECT i FROM InternalMemory i WHERE i.internal = ?1")
	InternalMemory findUnique(int internal);

}
