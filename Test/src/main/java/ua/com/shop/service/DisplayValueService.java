package ua.com.shop.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.com.shop.dto.filter.SimpleFilterDecimal;
import ua.com.shop.dto.form.DisplayValueForm;
import ua.com.shop.entity.DisplayValue;

public interface DisplayValueService {

	void save(DisplayValueForm displayValueForm);

	DisplayValue findOne(int id);

	List<DisplayValue> findAll();

	void delete(int id);

	void update(DisplayValue displayValue);

	DisplayValueForm findForm(int id);

	DisplayValue findUnique(String value);

	Page<DisplayValue> findAll(Pageable pageable, SimpleFilterDecimal filter);

}
