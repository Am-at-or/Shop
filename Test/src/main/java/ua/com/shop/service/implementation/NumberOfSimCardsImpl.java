package ua.com.shop.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ua.com.shop.dao.NumberOfSimCardsDao;
import ua.com.shop.dto.filter.SimpleFilterDecimal;
import ua.com.shop.dto.form.NumberOfSimCardsForm;
import ua.com.shop.entity.NumberOfSimCards;
import ua.com.shop.service.NumberOfSimCardsService;
import ua.com.shop.specification.NumberOfSimCardsSpecification;

@Service
public class NumberOfSimCardsImpl implements NumberOfSimCardsService {

	@Autowired
	private NumberOfSimCardsDao numberOfSimCardsDao;

	@Override
	public void save(NumberOfSimCardsForm form) {
		NumberOfSimCards entity = new NumberOfSimCards();
		entity.setId(form.getId());
		entity.setSimCards(Integer.valueOf(form.getSimCards()));
		numberOfSimCardsDao.save(entity);
	}

	@Override
	public NumberOfSimCards findOne(int id) {
		return numberOfSimCardsDao.findOne(id);
	}

	@Override
	public List<NumberOfSimCards> findAll() {
		return numberOfSimCardsDao.findAll();
	}

	@Override
	public void delete(int id) {
		numberOfSimCardsDao.delete(id);
	}

	@Override
	public void update(NumberOfSimCards numberOfSimCards) {
		numberOfSimCardsDao.save(numberOfSimCards);
	}

	@Override
	public NumberOfSimCardsForm findForm(int id) {
		NumberOfSimCardsForm form = new NumberOfSimCardsForm();
		NumberOfSimCards entity = numberOfSimCardsDao.findOne(id);
		form.setId(entity.getId());
		form.setSimCards(String.valueOf(entity.getSimCards()));
		return form;
	}

	@Override
	public NumberOfSimCards findUnique(String simCards) {
		return numberOfSimCardsDao.findUnique(Integer.valueOf(simCards));
	}

	@Override
	public Page<NumberOfSimCards> findAll(Pageable pageable,
			SimpleFilterDecimal filter) {
		return numberOfSimCardsDao.findAll(new NumberOfSimCardsSpecification(
				filter), pageable);
	}

}
