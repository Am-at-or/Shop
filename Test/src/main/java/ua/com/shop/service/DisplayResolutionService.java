package ua.com.shop.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.com.shop.dto.filter.DisplayResolutionFilter;
import ua.com.shop.dto.form.DisplayResolutionForm;
import ua.com.shop.entity.DisplayResolution;

public interface DisplayResolutionService {

	void save(DisplayResolutionForm form);

	DisplayResolution findOne(int id);

	List<DisplayResolution> findAll();

	void delete(int id);

	void update(DisplayResolution display);
	
	DisplayResolutionForm findForm(int id);

	DisplayResolution findUnique(String width, String height);

	Page<DisplayResolution> findAll(Pageable pageable, DisplayResolutionFilter filter);

}
