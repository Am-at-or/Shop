package ua.com.shop.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.shop.dao.PhoneDao;
import ua.com.shop.entity.Phone;
import ua.com.shop.service.PhoneService;

@Service
public class PhoneServiceImpl implements PhoneService {

	@Autowired
	private PhoneDao phoneDao;

	@Override
	public void save(Phone phone) {
		phoneDao.save(phone);
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
}
