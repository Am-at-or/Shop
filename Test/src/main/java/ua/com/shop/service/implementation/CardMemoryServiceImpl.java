package ua.com.shop.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.shop.dao.CardMemoryDao;
import ua.com.shop.dto.form.CardMemoryForm;
import ua.com.shop.entity.CardMemory;
import ua.com.shop.service.CardMemoryService;

@Service
public class CardMemoryServiceImpl implements CardMemoryService {

	@Autowired
	private CardMemoryDao cardMemoryDao;

	@Override
	public void save(CardMemoryForm form) {
		CardMemory entity = new CardMemory();
		entity.setId(form.getId());
		entity.setCard(Integer.valueOf(form.getCard()));
		cardMemoryDao.save(entity);
	}

	@Override
	public CardMemory findOne(int id) {
		return cardMemoryDao.findOne(id);
	}

	@Override
	public List<CardMemory> findAll() {
		return cardMemoryDao.findAll();
	}

	@Override
	public void delete(int id) {
		cardMemoryDao.delete(id);
	}

	@Override
	public void update(CardMemory cardMemory) {
		cardMemoryDao.save(cardMemory);
	}

	@Override
	public CardMemoryForm findForm(int id) {
		CardMemoryForm form = new CardMemoryForm();
		CardMemory entity = cardMemoryDao.findOne(id);
		form.setId(entity.getId());
		form.setCard(String.valueOf(entity.getCard()));
		return form;
	}

	@Override
	public CardMemory findUnique(String card) {
		return cardMemoryDao.findUnique(Integer.valueOf(card));
	}

}
