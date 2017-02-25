package ua.com.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.shop.entity.NumberOfCores;

public interface NumberOfCoresDao extends JpaRepository<NumberOfCores, Integer> {

}
