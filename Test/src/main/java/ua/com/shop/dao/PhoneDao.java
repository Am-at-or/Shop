package ua.com.shop.dao;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.com.shop.entity.Phone;

public interface PhoneDao extends JpaRepository<Phone, Integer>,
		JpaSpecificationExecutor<Phone> {

	@Query("select p from Phone p where p.price between :min and :max")
	List<Phone> findPhoneByPrice(@Param("min") int min, @Param("max") int max);

	@Query("SELECT p FROM Phone p WHERE p.maker.id = ?1 and p.model = ?2 and p.price = ?3 and p.displayValue = ?4 and p.displayResolution.id = ?5 and p.primaryCamera = ?6 and p.secondaryCamera = ?7 and p.processor.id = ?8 and p.ram = ?9 and p.internal = ?10 and p.card = ?11 and p.numberOfSimCards = ?12 and p.operatingSystem.id = ?13 and p.battery = ?14 and p.color.id = ?15")
	Phone findUnique(int makerId, String model, BigDecimal price,
			double displayValue, int displayResolutionId, double primaryCamera,
			double secondaryCamera, int processorId, double ram,
			double internal, double card, int numberOfSimCards,
			int operatingSystemId, int battery, int colorId);

	@Query("select p from Phone p where p.maker.name = ?1")
	List<Phone> findByMaker(String name);
	
}
