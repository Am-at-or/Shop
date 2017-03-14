package ua.com.shop.specification;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import ua.com.shop.dto.filter.OperatingSystemFilter;
import ua.com.shop.entity.OperatingSystem;

public class OperatingSystemSpecification implements
		Specification<OperatingSystem> {

	private final OperatingSystemFilter filter;
	private final List<Predicate> predicates = new ArrayList<>();
	private final static Pattern PATTERN = Pattern
			.compile("^([0-9]{1,17}\\.[0-9]{1,2})|([0-9]{1,17}\\,[0-9]{1,2})|([0-9]{1,17})$");

	public OperatingSystemSpecification(OperatingSystemFilter filter) {
		this.filter = filter;
		if (PATTERN.matcher(filter.getMinVersion()).matches()) {
			filter.setMinVersionValue(new BigDecimal(filter.getMinVersion()
					.replace(',', '.')));
		}
		if (PATTERN.matcher(filter.getMaxVersion()).matches()) {
			filter.setMaxVersionValue(new BigDecimal(filter.getMaxVersion()
					.replace(',', '.')));
		}
	}

	private void filterByOperatingSystem(Root<OperatingSystem> root,
			CriteriaQuery<?> query, CriteriaBuilder cb) {
		if (!filter.getNameIds().isEmpty()) {
			predicates.add(root.get("name").in(filter.getNameIds()));
		}
		if (filter.getMinVersionValue() != null) {
			predicates.add(cb.ge(root.get("version"),
					filter.getMinVersionValue()));
		}
		if (filter.getMaxVersionValue() != null) {
			predicates.add(cb.le(root.get("version"),
					filter.getMaxVersionValue()));
		}
	}

	@Override
	public Predicate toPredicate(Root<OperatingSystem> root,
			CriteriaQuery<?> query, CriteriaBuilder cb) {
		filterByOperatingSystem(root, query, cb);
		if (predicates.isEmpty())
			return null;
		Predicate[] arr = new Predicate[predicates.size()];
		arr = predicates.toArray(arr);
		return cb.and(arr);
	}

}