package ua.com.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import ua.com.shop.entity.User;

public interface UserDao extends JpaRepository<User, Integer>,
		JpaSpecificationExecutor<User> {

	User findByLogin(String username);

	@Query("SELECT u FROM User u WHERE u.login = ?1")
	User findUnique(String login);

}
