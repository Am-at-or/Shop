package ua.com.shop.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import ua.com.shop.dto.filter.SimpleFilter;
import ua.com.shop.entity.OSName;

public class OSNameSpecification implements Specification<OSName> {

	private final SimpleFilter filter;

	public OSNameSpecification(SimpleFilter filter) {
		this.filter = filter;
	}

	@Override
	public Predicate toPredicate(Root<OSName> root, CriteriaQuery<?> query,
			CriteriaBuilder cb) {
		if (filter.getSearch().isEmpty())
			return null;
		return cb.like(cb.lower(root.get("name")), filter.getSearch()
				.toLowerCase() + "%");
	}

}
