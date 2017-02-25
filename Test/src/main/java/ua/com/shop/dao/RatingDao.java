package ua.com.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.shop.entity.Rating;

public interface RatingDao extends JpaRepository<Rating, Integer> {

}
