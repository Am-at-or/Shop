package ua.com.shop.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import ua.com.shop.dto.filter.DisplayFilter;
import ua.com.shop.entity.Display;

public class DisplaySpecification implements Specification<Display> {

	private final DisplayFilter filter;

	private final List<Predicate> predicates = new ArrayList<>();

	public DisplaySpecification(DisplayFilter filter) {
		this.filter = filter;
	}

	private void filterByDisplaySize(Root<Display> root,
			CriteriaQuery<?> query, CriteriaBuilder cb) {
		if (!filter.getDisplayValueIds().isEmpty()) {
			predicates.add(root.get("value").in(filter.getDisplayValueIds()));
		}
	}

	private void filterByDisplayWidth(Root<Display> root,
			CriteriaQuery<?> query, CriteriaBuilder cb) {
		if (!filter.getDisplayWidthIds().isEmpty()) {
			predicates.add(root.get("width").in(filter.getDisplayWidthIds()));
		}
	}

	private void filterByDisplayHeight(Root<Display> root,
			CriteriaQuery<?> query, CriteriaBuilder cb) {
		if (!filter.getDisplayHeightIds().isEmpty()) {
			predicates.add(root.get("height").in(filter.getDisplayHeightIds()));
		}
	}

	private void filterByDisplayTechnology(Root<Display> root,
			CriteriaQuery<?> query, CriteriaBuilder cb) {
		if (!filter.getDisplayTechnologyIds().isEmpty()) {
			predicates.add(root.get("technology").in(
					filter.getDisplayTechnologyIds()));
		}
	}

	private void fetch(Root<Display> root, CriteriaQuery<?> query) {
		if (!query.getResultType().equals(Long.class)) {
			query.distinct(true);
			root.fetch("value");
			root.fetch("width");
			root.fetch("height");
			root.fetch("technology");
		}
	}

	@Override
	public Predicate toPredicate(Root<Display> root, CriteriaQuery<?> query,
			CriteriaBuilder cb) {
		fetch(root, query);
		filterByDisplaySize(root, query, cb);
		filterByDisplayWidth(root, query, cb);
		filterByDisplayHeight(root, query, cb);
		filterByDisplayTechnology(root, query, cb);
		if (predicates.isEmpty())
			return null;
		Predicate[] arr = new Predicate[predicates.size()];
		arr = predicates.toArray(arr);
		return cb.and(arr);
	}

}
