package ua.com.shop.service.implementation;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ua.com.shop.dao.UserDao;
import ua.com.shop.dto.filter.UserFilter;
import ua.com.shop.entity.Role;
import ua.com.shop.entity.User;
import ua.com.shop.service.UserService;
import ua.com.shop.specification.UserSpecification;

@Service("userDetailsService")
public class UserServiceImpl implements UserService, UserDetailsService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Override
	public void save(User user) {
		user.setRole(Role.ROLE_USER);
		user.setPassword(encoder.encode(user.getPassword()));
		userDao.save(user);
	}

	@Override
	public User findOne(int id) {
		return userDao.findOne(id);
	}

	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}

	@Override
	public void delete(int id) {
		userDao.delete(id);
	}

	@Override
	public void update(User user) {
		userDao.save(user);
	}

	@Override
	public User findUnique(String login) {
		return userDao.findUnique(login);
	}

	@Override
	public Page<User> findAll(Pageable pageable, UserFilter filter) {
		return userDao.findAll(new UserSpecification(filter), pageable);
	}

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		return userDao.findByLogin(username);
	}

	@PostConstruct
	public void addAdmin() {
		User user = userDao.findByLogin("admin");
		if (user == null) {
			user = new User();
			user.setLogin("admin");
			user.setPassword(encoder.encode("admin"));
			user.setRole(Role.ROLE_ADMIN);
			userDao.save(user);
		}
	}
}
