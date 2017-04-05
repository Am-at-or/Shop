package ua.com.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import ua.com.shop.entity.ProcessorMaker;

public interface ProcessorMakerDao extends
		JpaRepository<ProcessorMaker, Integer>, JpaSpecificationExecutor<ProcessorMaker> {

	@Query("SELECT p FROM ProcessorMaker p WHERE p.maker = ?1")
	ProcessorMaker findByProcessorMaker(String maker);

}
