package ua.com.shop.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.shop.dao.PhoneDao;
import ua.com.shop.dto.form.PhoneForm;
import ua.com.shop.entity.Color;
import ua.com.shop.entity.Display;
import ua.com.shop.entity.Maker;
import ua.com.shop.entity.OperatingSystem;
import ua.com.shop.entity.Phone;
import ua.com.shop.entity.Processor;
import ua.com.shop.service.PhoneService;

@Service
public class PhoneServiceImpl implements PhoneService {

	@Autowired
	private PhoneDao phoneDao;

	@Override
	public void save(PhoneForm form) {
		Phone entity = new Phone();
		entity.setId(form.getId());
		entity.setMaker(form.getMaker());
		entity.setModel(form.getModel());
		entity.setPrice(form.getPrice());
		entity.setDisplay(form.getDisplay());
		entity.setPrimaryCamera(form.getPrimaryCamera());
		entity.setSecondaryCamera(form.getSecondaryCamera());
		entity.setProcessor(form.getProcessor());
		entity.setRam(form.getRam());
		entity.setInternal(form.getInternal());
		entity.setCard(form.getCard());
		entity.setNumberOfSimCards(form.getNumberOfSimCards());
		entity.setOperatingSystem(form.getOperatingSystem());
		entity.setBattery(form.getBattery());
		entity.setColor(form.getColor());
		phoneDao.save(entity);
	}

	@Override
	public Phone findOne(int id) {
		return phoneDao.findOne(id);
	}

	@Override
	public List<Phone> findAll() {
		return phoneDao.findAll();
	}

	@Override
	public void delete(int id) {
		phoneDao.delete(id);
	}

	@Override
	public void update(Phone phone) {
		phoneDao.save(phone);
	}

	public List<Phone> findPhoneByPrice(int min, int max) {
		return phoneDao.findPhoneByPrice(min, max);
	}

	@Override
	public PhoneForm findForm(int id) {
		PhoneForm form = new PhoneForm();
		Phone entity = phoneDao.findOne(id);
		form.setId(entity.getId());
		form.setMaker(entity.getMaker());
		form.setModel(entity.getModel());
		form.setPrice(entity.getPrice());
		form.setDisplay(entity.getDisplay());
		form.setPrimaryCamera(entity.getPrimaryCamera());
		form.setSecondaryCamera(entity.getSecondaryCamera());
		form.setProcessor(entity.getProcessor());
		form.setRam(entity.getRam());
		form.setInternal(entity.getInternal());
		form.setCard(entity.getCard());
		form.setNumberOfSimCards(entity.getNumberOfSimCards());
		form.setOperatingSystem(entity.getOperatingSystem());
		form.setBattery(entity.getBattery());
		form.setColor(entity.getColor());
		return form;
	}

	@Override
	public Phone findUnique(Maker maker, String model, int price,
			Display display, int primaryCamera, int secondaryCamera,
			Processor processor, int ram, int internal, int card,
			int numberOfSimCards, OperatingSystem operatingSystem, int battery,
			Color color) {
		return phoneDao.findUnique(maker.getId(), model, price,
				display.getId(), primaryCamera, secondaryCamera,
				processor.getId(), ram, internal, card, numberOfSimCards,
				operatingSystem.getId(), battery, color.getId());
	}

}
