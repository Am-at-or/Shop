package ua.com.shop.service;

import java.util.List;

import ua.com.shop.dto.form.PhoneForm;
import ua.com.shop.entity.CardMemory;
import ua.com.shop.entity.Color;
import ua.com.shop.entity.Display;
import ua.com.shop.entity.InternalMemory;
import ua.com.shop.entity.Maker;
import ua.com.shop.entity.NumberOfSimCards;
import ua.com.shop.entity.OperatingSystem;
import ua.com.shop.entity.Phone;
import ua.com.shop.entity.Processor;
import ua.com.shop.entity.Ram;

public interface PhoneService {

	void save(PhoneForm phone);

	Phone findOne(int id);

	List<Phone> findAll();

	void delete(int id);

	void update(Phone phone);

	PhoneForm findForm(int id);

	Phone findUnique(Maker maker, String model, String price, Display display,
			String primaryCamera, String secondaryCamera, Processor processor,
			Ram ram, InternalMemory internal, CardMemory card,
			NumberOfSimCards numberOfSimCards, OperatingSystem operatingSystem,
			String battery, Color color);

	List<Phone> findPhoneByPrice(int min, int max);

}
