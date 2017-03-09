package ua.com.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import ua.com.shop.entity.NumberOfSimCards;

public interface NumberOfSimCardsDao extends
		JpaRepository<NumberOfSimCards, Integer>,
		JpaSpecificationExecutor<NumberOfSimCards> {

	@Query("SELECT n FROM NumberOfSimCards n WHERE n.simCards = ?1")
	NumberOfSimCards findUnique(int simCards);

}
