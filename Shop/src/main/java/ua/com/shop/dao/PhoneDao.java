package ua.com.shop.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.com.shop.entity.Phone;

public interface PhoneDao extends JpaRepository<Phone, Integer> {

	@Query("select p from Phone p where p.price between :min and :max")
	List<Phone> findPhoneByPrice(@Param("min") int min,
			@Param("max") int max);

}
