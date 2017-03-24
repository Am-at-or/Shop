package ua.com.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.shop.entity.People;

public interface  PeopleDao extends JpaRepository<People, Integer> {

}
