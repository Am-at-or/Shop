package ua.com.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.shop.entity.ProcessorMaker;

public interface ProcessorMakerDao extends
		JpaRepository<ProcessorMaker, Integer> {

}
