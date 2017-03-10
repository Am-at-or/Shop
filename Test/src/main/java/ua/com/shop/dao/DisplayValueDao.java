package ua.com.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import ua.com.shop.entity.DisplayValue;

public interface DisplayValueDao extends JpaRepository<DisplayValue, Integer>,
		JpaSpecificationExecutor<DisplayValue> {

	@Query("SELECT d FROM DisplayValue d WHERE d.value = ?1")
	DisplayValue findUnique(double value);

}
