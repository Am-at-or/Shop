package ua.com.shop.service;

import java.util.List;

import ua.com.shop.dto.form.OperatingSystemForm;
import ua.com.shop.entity.OSName;
import ua.com.shop.entity.OperatingSystem;

public interface OperatingSystemService {

	void save(OperatingSystemForm form);

	OperatingSystem findOne(int id);

	List<OperatingSystem> findAll();

	void delete(int id);

	void update(OperatingSystem operatingSystem);

	OperatingSystemForm findForm(int id);

	OperatingSystem findUnique(OSName nameId, String version);

}
