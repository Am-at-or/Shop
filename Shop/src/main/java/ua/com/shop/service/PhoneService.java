package ua.com.shop.service;

import java.util.List;

import ua.com.shop.entity.Phone;

public interface PhoneService {

	void save(Phone phone);

	Phone findOne(int id);

	List<Phone> findAll();

	void delete(int id);

	void update(Phone phone);

	List<Phone> findPhoneByPrice(int min, int max);

}
