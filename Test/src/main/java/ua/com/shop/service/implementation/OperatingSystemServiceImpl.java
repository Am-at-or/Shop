package ua.com.shop.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ua.com.shop.dao.OperatingSystemDao;
import ua.com.shop.dto.filter.OperatingSystemFilter;
import ua.com.shop.dto.form.OperatingSystemForm;
import ua.com.shop.entity.OSName;
import ua.com.shop.entity.OperatingSystem;
import ua.com.shop.service.OperatingSystemService;
import ua.com.shop.specification.OperatingSystemSpecification;

@Service
public class OperatingSystemServiceImpl implements OperatingSystemService {

	@Autowired
	private OperatingSystemDao operatingSystemDao;

	@Override
	public void save(OperatingSystemForm form) {
		OperatingSystem entity = new OperatingSystem();
		entity.setId(form.getId());
		entity.setName(form.getName());
		entity.setVersion(Double.valueOf(form.getVersion().replace(",", ".")));
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
				Double.valueOf(version.replace(",", ".")));
	}

	@Override
	public OperatingSystemForm findForm(int id) {
		OperatingSystemForm form = new OperatingSystemForm();
		OperatingSystem entity = operatingSystemDao.findOne(id);
		form.setId(entity.getId());
		form.setName(entity.getName());
		form.setVersion(String.valueOf(entity.getVersion()));
		return form;
	}

	@Override
	public Page<OperatingSystem> findAll(Pageable pageable,
			OperatingSystemFilter filter) {
		return operatingSystemDao.findAll(new OperatingSystemSpecification(
				filter), pageable);
	}

}
