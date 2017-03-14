package ua.com.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import ua.com.shop.entity.Processor;

public interface ProcessorDao extends JpaRepository<Processor, Integer>,
		JpaSpecificationExecutor<Processor> {

	@Query("SELECT p FROM Processor p WHERE p.maker.id = ?1 and p.model = ?2 and p.frequency = ?3 and p.numberOfCores = ?4")
	Processor findUnique(int makerId, String model, double frequency,
			int numberOfCores);

}
