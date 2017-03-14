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

import ua.com.shop.dto.filter.ProcessorFilter;
import ua.com.shop.entity.Processor;

public class ProcessorSpecification implements Specification<Processor> {

	private final ProcessorFilter filter;
	private final List<Predicate> predicates = new ArrayList<>();
	private final static Pattern PATTERN = Pattern
			.compile("^([0-9]{1,17}\\.[0-9]{1,2})|([0-9]{1,17}\\,[0-9]{1,2})|([0-9]{1,17})$");
	private final static Pattern PATTERN1 = Pattern.compile("([0-9]{1,9})");

	public ProcessorSpecification(ProcessorFilter filter) {
		this.filter = filter;
		if (PATTERN.matcher(filter.getMinFrequency()).matches()) {
			filter.setMinFrequencyValue(new BigDecimal(filter.getMinFrequency()
					.replace(',', '.')));
		}
		if (PATTERN.matcher(filter.getMaxFrequency()).matches()) {
			filter.setMaxFrequencyValue(new BigDecimal(filter.getMaxFrequency()
					.replace(',', '.')));
		}
		if (PATTERN1.matcher(filter.getNumberOfCoresFilter()).matches()) {
			filter.setNumberOfCoresValue(Integer.valueOf(filter
					.getNumberOfCoresFilter()));

		}
	}

	private void filterByProcessor(Root<Processor> root,
			CriteriaQuery<?> query, CriteriaBuilder cb) {
		if (!filter.getMakerIds().isEmpty()) {
			predicates.add(root.get("maker").in(filter.getMakerIds()));
		}
		if (!filter.getModelFilter().isEmpty()) {
			predicates.add(cb.like(cb.lower(root.get("model")), filter
					.getModelFilter().toLowerCase() + "%"));
		}
		if (filter.getMinFrequencyValue() != null) {
			predicates.add(cb.ge(root.get("frequency"),
					filter.getMinFrequencyValue()));
		}
		if (filter.getMaxFrequencyValue() != null) {
			predicates.add(cb.le(root.get("frequency"),
					filter.getMaxFrequencyValue()));
		}

		if (filter.getNumberOfCoresValue() != null) {
			predicates.add(cb.equal(root.get("numberOfCores"),
					filter.getNumberOfCoresValue()));
		}
	}

	@Override
	public Predicate toPredicate(Root<Processor> root, CriteriaQuery<?> query,
			CriteriaBuilder cb) {
		filterByProcessor(root, query, cb);
		if (predicates.isEmpty())
			return null;
		Predicate[] arr = new Predicate[predicates.size()];
		arr = predicates.toArray(arr);
		return cb.and(arr);
	}

}
