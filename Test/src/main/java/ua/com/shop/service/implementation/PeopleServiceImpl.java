package ua.com.shop.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.shop.dao.PeopleDao;
import ua.com.shop.entity.People;
import ua.com.shop.service.PeopleService;

@Service
public class PeopleServiceImpl implements PeopleService {

	@Autowired
	PeopleDao peopleDao;

	@Override
	public List<People> findAll() {
		return peopleDao.findAll();
	}

	@Override
	public People save(People people) {
		return peopleDao.saveAndFlush(people);
	}

	@Override
	public void delete(int id) {
		peopleDao.delete(id);

	}

	@Override
	public People findOne(int id) {
		return peopleDao.findOne(id);
	}

}
