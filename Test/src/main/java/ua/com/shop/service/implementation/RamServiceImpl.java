package ua.com.shop.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.shop.dao.RamDao;
import ua.com.shop.dto.form.RamForm;
import ua.com.shop.entity.Ram;
import ua.com.shop.service.RamService;

@Service
public class RamServiceImpl implements RamService {

	@Autowired
	private RamDao ramDao;

	@Override
	public void save(RamForm form) {
		Ram entity = new Ram();
		entity.setId(form.getId());
		entity.setRam(Integer.valueOf(form.getRam()));
		ramDao.save(entity);
	}

	@Override
	public Ram findOne(int id) {
		return ramDao.findOne(id);
	}

	@Override
	public List<Ram> findAll() {
		return ramDao.findAll();
	}

	@Override
	public void delete(int id) {
		ramDao.delete(id);
	}

	@Override
	public void update(Ram ram) {
		ramDao.save(ram);
	}

	@Override
	public RamForm findForm(int id) {
		RamForm form = new RamForm();
		Ram entity = ramDao.findOne(id);
		form.setId(entity.getId());
		form.setRam(String.valueOf(entity.getRam()));
		return form;
	}

	@Override
	public Ram findUnique(String ram) {
		return ramDao.findUnique(Integer.valueOf(ram));
	}

}
