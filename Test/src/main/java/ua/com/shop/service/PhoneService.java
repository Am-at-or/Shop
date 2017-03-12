package ua.com.shop.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.com.shop.dto.filter.PhoneFilter;
import ua.com.shop.dto.form.PhoneForm;
import ua.com.shop.entity.Color;
import ua.com.shop.entity.DisplayResolution;
import ua.com.shop.entity.Maker;
import ua.com.shop.entity.OperatingSystem;
import ua.com.shop.entity.Phone;
import ua.com.shop.entity.Processor;

public interface PhoneService {

	void save(PhoneForm form);

	Phone findOne(int id);

	List<Phone> findAll();

	void delete(int id);

	void update(Phone phone);

	PhoneForm findForm(int id);

	Phone findUnique(Maker maker, String model, String price,
			String displayValue, DisplayResolution displayResolution,
			String primaryCamera, String secondaryCamera, Processor processor,
			String ram, String internal, String card, String numberOfSimCards,
			OperatingSystem operatingSystem, String battery, Color color);

	Page<Phone> findAll(Pageable pageable, PhoneFilter filter);

}
