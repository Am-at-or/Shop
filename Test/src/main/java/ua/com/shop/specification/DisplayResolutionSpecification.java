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

import ua.com.shop.dto.filter.DisplayResolutionFilter;
import ua.com.shop.entity.DisplayResolution;

public class DisplayResolutionSpecification implements
		Specification<DisplayResolution> {

	private final DisplayResolutionFilter filter;

	private final List<Predicate> predicates = new ArrayList<>();

	private final static Pattern PATTERN = Pattern
			.compile("^([0-9]{1,17}\\.[0-9]{1,2})|([0-9]{1,17}\\,[0-9]{1,2})|([0-9]{1,17})$");

	public DisplayResolutionSpecification(DisplayResolutionFilter filter) {
		this.filter = filter;
		if (PATTERN.matcher(filter.getMinWidth()).matches()) {
			filter.setMinWidthValue(new BigDecimal(filter.getMinWidth()
					.replace(',', '.')));
		}
		if (PATTERN.matcher(filter.getMaxWidth()).matches()) {
			filter.setMaxWidthValue(new BigDecimal(filter.getMaxWidth()
					.replace(',', '.')));
		}
		if (PATTERN.matcher(filter.getMinHeight()).matches()) {
			filter.setMinHeightValue(new BigDecimal(filter.getMinHeight()
					.replace(',', '.')));
		}
		if (PATTERN.matcher(filter.getMaxHeight()).matches()) {
			filter.setMaxHeightValue(new BigDecimal(filter.getMaxHeight()
					.replace(',', '.')));
		}
	}

	private void filterByDisplayResolution(Root<DisplayResolution> root,
			CriteriaQuery<?> query, CriteriaBuilder cb) {
		if (filter.getMinWidthValue() != null) {
			predicates.add(cb.ge(root.get("width"), filter.getMinWidthValue()));
		}
		if (filter.getMaxWidthValue() != null) {
			predicates.add(cb.le(root.get("width"), filter.getMaxWidthValue()));
		}
		if (filter.getMinHeightValue() != null) {
			predicates
					.add(cb.ge(root.get("height"), filter.getMinHeightValue()));
		}
		if (filter.getMaxHeightValue() != null) {
			predicates
					.add(cb.le(root.get("height"), filter.getMaxHeightValue()));
		}
	}

	@Override
	public Predicate toPredicate(Root<DisplayResolution> root,
			CriteriaQuery<?> query, CriteriaBuilder cb) {
		filterByDisplayResolution(root, query, cb);
		if (predicates.isEmpty())
			return null;
		Predicate[] arr = new Predicate[predicates.size()];
		arr = predicates.toArray(arr);
		return cb.and(arr);
	}

}
