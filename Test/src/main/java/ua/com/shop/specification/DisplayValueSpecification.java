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

import ua.com.shop.dto.filter.SimpleFilterDecimal;
import ua.com.shop.entity.DisplayValue;

public class DisplayValueSpecification implements Specification<DisplayValue> {

	private final SimpleFilterDecimal filter;

	private final List<Predicate> predicates = new ArrayList<>();

	private final static Pattern PATTERN = Pattern
			.compile("^([0-9]{1,17}\\.[0-9]{1,2})|([0-9]{1,17}\\,[0-9]{1,2})|([0-9]{1,17})$");

	public DisplayValueSpecification(SimpleFilterDecimal filter) {
		this.filter = filter;
		if (PATTERN.matcher(filter.getMin()).matches()) {
			filter.setMinValue(new BigDecimal(filter.getMin().replace(',', '.')));
		}
		if (PATTERN.matcher(filter.getMax()).matches()) {
			filter.setMaxValue(new BigDecimal(filter.getMax().replace(',', '.')));
		}
	}

	private void filterByDisplayValue(Root<DisplayValue> root,
			CriteriaQuery<?> query, CriteriaBuilder cb) {
		if (filter.getMinValue() != null) {
			predicates.add(cb.ge(root.get("value"), filter.getMinValue()));
		}
		if (filter.getMaxValue() != null) {
			predicates.add(cb.le(root.get("value"), filter.getMaxValue()));
		}
	}

	@Override
	public Predicate toPredicate(Root<DisplayValue> root,
			CriteriaQuery<?> query, CriteriaBuilder cb) {
		filterByDisplayValue(root, query, cb);
		if (predicates.isEmpty())
			return null;
		Predicate[] arr = new Predicate[predicates.size()];
		arr = predicates.toArray(arr);
		return cb.and(arr);
	}

}
