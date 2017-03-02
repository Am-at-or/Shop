package ua.com.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.com.shop.entity.CardMemory;

public interface CardMemoryDao extends JpaRepository<CardMemory, Integer> {

	@Query("SELECT c FROM CardMemory c WHERE c.card = ?1")
	CardMemory findUnique(int card);

}
