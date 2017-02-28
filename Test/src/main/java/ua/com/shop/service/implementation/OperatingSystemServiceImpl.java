package ua.com.shop.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.shop.dao.OperatingSystemDao;
import ua.com.shop.dto.form.OperatingSystemForm;
import ua.com.shop.entity.OSName;
import ua.com.shop.entity.OperatingSystem;
import ua.com.shop.service.OperatingSystemService;

@Service
public class OperatingSystemServiceImpl implements OperatingSystemService {

	@Autowired
	private OperatingSystemDao operatingSystemDao;

	@Override
	public void save(OperatingSystemForm form) {
		OperatingSystem entity = new OperatingSystem();
		entity.setId(form.getId());
		entity.setName(form.getName());
		entity.setVersion(form.getVersion());
		operatingSystemDao.save(entity);
	}

	@Override
	public OperatingSystem findOne(int id) {
		return operatingSystemDao.findOne(id);
	}

	@Override
	public List<OperatingSystem> findAll() {
		return operatingSystemDao.findAll();
	}

	@Override
	public void delete(int id) {
		operatingSystemDao.delete(id);
	}

	@Override
	public void update(OperatingSystem operatingSystem) {
		operatingSystemDao.save(operatingSystem);
	}

	@Override
	public OperatingSystem findUnique(OSName nameId, String version) {
		return operatingSystemDao.findUnique(nameId.getId(),
				version.replace(",", "."));
	}

	@Override
	public OperatingSystemForm findForm(int id) {
		OperatingSystemForm form = new OperatingSystemForm();
		OperatingSystem entity = operatingSystemDao.findOne(id);
		form.setId(entity.getId());
		form.setName(entity.getName());
		form.setVersion(entity.getVersion().replace(",", "."));
		return form;
	}

}
