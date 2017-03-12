package ua.com.shop.service.implementation;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ua.com.shop.dao.PhoneDao;
import ua.com.shop.dto.filter.PhoneFilter;
import ua.com.shop.dto.form.PhoneForm;
import ua.com.shop.entity.Color;
import ua.com.shop.entity.DisplayResolution;
import ua.com.shop.entity.Maker;
import ua.com.shop.entity.OperatingSystem;
import ua.com.shop.entity.Phone;
import ua.com.shop.entity.Processor;
import ua.com.shop.service.PhoneService;
import ua.com.shop.specification.PhoneSpecification;

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
		entity.setPrice(new BigDecimal(form.getPrice().replace(",", ".")));
		entity.setDisplayValue(Double.valueOf(form.getDisplayValue().replace(
				",", ".")));
		entity.setDisplayResolution(form.getDisplayResolution());
		entity.setPrimaryCamera(Double.valueOf(form.getPrimaryCamera().replace(
				",", ".")));
		entity.setSecondaryCamera(Double.valueOf(form.getSecondaryCamera()
				.replace(",", ".")));
		entity.setProcessor(form.getProcessor());
		entity.setRam(Double.valueOf(form.getRam().replace(",", ".")));
		entity.setInternal(Double.valueOf(form.getInternal().replace(",", ".")));
		entity.setCard(Double.valueOf(form.getCard().replace(",", ".")));
		entity.setNumberOfSimCards(Integer.valueOf(form.getNumberOfSimCards()));
		entity.setOperatingSystem(form.getOperatingSystem());
		entity.setBattery(Integer.valueOf(form.getBattery()));
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

	@Override
	public PhoneForm findForm(int id) {
		PhoneForm form = new PhoneForm();
		Phone entity = phoneDao.findOne(id);
		form.setId(entity.getId());
		form.setMaker(entity.getMaker());
		form.setModel(entity.getModel());
		form.setPrice(String.valueOf(entity.getPrice()));
		form.setDisplayValue(String.valueOf(entity.getDisplayValue()));
		form.setDisplayResolution(entity.getDisplayResolution());
		form.setPrimaryCamera(String.valueOf(entity.getPrimaryCamera()));
		form.setSecondaryCamera(String.valueOf(entity.getSecondaryCamera()));
		form.setProcessor(entity.getProcessor());
		form.setRam(String.valueOf(entity.getRam()));
		form.setInternal(String.valueOf(entity.getInternal()));
		form.setCard(String.valueOf(entity.getCard()));
		form.setNumberOfSimCards(String.valueOf(entity.getNumberOfSimCards()));
		form.setOperatingSystem(entity.getOperatingSystem());
		form.setBattery(String.valueOf(entity.getBattery()));
		form.setColor(entity.getColor());
		return form;
	}

	@Override
	public Phone findUnique(Maker maker, String model, String price,
			String displayValue, DisplayResolution displayResolution,
			String primaryCamera, String secondaryCamera, Processor processor,
			String ram, String internal, String card, String numberOfSimCards,
			OperatingSystem operatingSystem, String battery, Color color) {
		return phoneDao.findUnique(maker.getId(), model,
				new BigDecimal(price.replace(",", ".")),
				Double.valueOf(displayValue.replace(",", ".")),
				displayResolution.getId(),
				Double.valueOf(primaryCamera.replace(",", ".")),
				Double.valueOf(secondaryCamera.replace(",", ".")),
				processor.getId(), Double.valueOf(ram.replace(",", ".")),
				Double.valueOf(internal.replace(",", ".")),
				Double.valueOf(card.replace(",", ".")),
				Integer.valueOf(numberOfSimCards), operatingSystem.getId(),
				Integer.valueOf(battery), color.getId());
	}

	@Override
	public Page<Phone> findAll(Pageable pageable, PhoneFilter filter) {
		return phoneDao.findAll(new PhoneSpecification(filter), pageable);
	}

}
