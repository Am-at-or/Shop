package ua.com.shop.service;

import java.util.List;

import ua.com.shop.dto.form.NumberOfSimCardsForm;
import ua.com.shop.entity.NumberOfSimCards;

public interface NumberOfSimCardsService {

	void save(NumberOfSimCardsForm numberOfSimCardsForm);

	NumberOfSimCards findOne(int id);

	List<NumberOfSimCards> findAll();

	void delete(int id);

	void update(NumberOfSimCards numberOfSimCards);

	NumberOfSimCards findUnique(String simCards);

	NumberOfSimCardsForm findForm(int id);

}
