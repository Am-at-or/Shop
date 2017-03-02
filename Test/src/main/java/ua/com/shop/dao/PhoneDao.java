package ua.com.shop.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.com.shop.entity.Phone;

public interface PhoneDao extends JpaRepository<Phone, Integer> {

	@Query("select p from Phone p where p.price between :min and :max")
	List<Phone> findPhoneByPrice(@Param("min") int min, @Param("max") int max);

	@Query("SELECT p FROM Phone p WHERE p.maker.id = ?1 and p.model = ?2 and p.price = ?3 and p.display.id = ?4 and p.primaryCamera = ?5 and p.secondaryCamera = ?6 and p.processor.id = ?7 and p.ram.id = ?8 and p.internal = ?9 and p.card = ?10 and p.numberOfSimCards.id = ?11 and p.operatingSystem.id = ?12 and p.battery = ?13 and p.color.id = ?14")
	Phone findUnique(int makerId, String model, int price, int displayId,
			int primaryCamera, int secondaryCamera, int processorId, int ramId,
			int internal, int card, int numberOfSimCardsId,
			int operatingSystemId, int battery, int colorId);

}
