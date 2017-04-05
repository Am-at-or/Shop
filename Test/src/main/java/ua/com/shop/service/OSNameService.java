package ua.com.shop.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.com.shop.dto.filter.SimpleFilter;
import ua.com.shop.entity.OSName;

public interface OSNameService {

	void save(OSName osName);

	OSName findOne(int id);

	List<OSName> findAll();

	void delete(int id);

	void update(OSName osName);

	OSName findByName(String name);

	Page<OSName> findAll(Pageable pageable, SimpleFilter filter);

}
