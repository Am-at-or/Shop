package ua.com.shop.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import ua.com.shop.dto.filter.UserFilter;
import ua.com.shop.entity.User;

public class UserSpecification implements Specification<User> {

	private final UserFilter filter;
	private final List<Predicate> predicates = new ArrayList<>();

	public UserSpecification(UserFilter filter) {
		this.filter = filter;
	}

	private void filterByUser(Root<User> root, CriteriaQuery<?> query,
			CriteriaBuilder cb) {
		if (!filter.getEmailFilter().isEmpty()) {
			predicates.add(cb.like(cb.lower(root.get("email")), filter
					.getEmailFilter().toLowerCase() + "%"));
		}
		if (!filter.getLoginFilter().isEmpty()) {
			predicates.add(cb.like(cb.lower(root.get("login")), filter
					.getLoginFilter().toLowerCase() + "%"));
		}
		if (!filter.getPhoneNumberFilter().isEmpty()) {
			predicates.add(cb.like(cb.lower(root.get("phoneNumber")), filter
					.getPhoneNumberFilter().toLowerCase() + "%"));
		}
		if (!filter.getFirstNameFilter().isEmpty()) {
			predicates.add(cb.like(cb.lower(root.get("firstName")), filter
					.getFirstNameFilter().toLowerCase() + "%"));
		}
		if (!filter.getLastNameFilter().isEmpty()) {
			predicates.add(cb.like(cb.lower(root.get("lastName")), filter
					.getLastNameFilter().toLowerCase() + "%"));
		}

	}

	@Override
	public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query,
			CriteriaBuilder cb) {
		filterByUser(root, query, cb);
		if (predicates.isEmpty())
			return null;
		Predicate[] arr = new Predicate[predicates.size()];
		arr = predicates.toArray(arr);
		return cb.and(arr);
	}
}