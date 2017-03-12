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

import ua.com.shop.dto.filter.PhoneFilter;
import ua.com.shop.entity.Phone;

public class PhoneSpecification implements Specification<Phone> {

	private final PhoneFilter filter;
	private final List<Predicate> predicates = new ArrayList<>();
	private final static Pattern PATTERN = Pattern
			.compile("^([0-9]{1,17}\\.[0-9]{1,2})|([0-9]{1,17}\\,[0-9]{1,2})|([0-9]{1,17})$");
	private final static Pattern PATTERN1 = Pattern.compile("([0-9]{1,9})");

	public PhoneSpecification(PhoneFilter filter) {
		this.filter = filter;
		if (PATTERN.matcher(filter.getMinPrice()).matches()) {
			filter.setMinPriceValue(new BigDecimal(filter.getMinPrice()
					.replace(',', '.')));
		}
		if (PATTERN.matcher(filter.getMaxPrice()).matches()) {
			filter.setMaxPriceValue(new BigDecimal(filter.getMaxPrice()
					.replace(',', '.')));
		}
		if (PATTERN.matcher(filter.getMinDisplayValue()).matches()) {
			filter.setMinDisplayValueV(new BigDecimal(filter
					.getMinDisplayValue().replace(',', '.')));
		}
		if (PATTERN.matcher(filter.getMaxDisplayValue()).matches()) {
			filter.setMaxDisplayValueV(new BigDecimal(filter
					.getMaxDisplayValue().replace(',', '.')));
		}
		if (PATTERN.matcher(filter.getMinPrimaryCamera()).matches()) {
			filter.setMinPrimaryCameraValue(new BigDecimal(filter
					.getMinPrimaryCamera().replace(',', '.')));
		}
		if (PATTERN.matcher(filter.getMaxPrimaryCamera()).matches()) {
			filter.setMaxPrimaryCameraValue(new BigDecimal(filter
					.getMaxPrimaryCamera().replace(',', '.')));
		}
		if (PATTERN.matcher(filter.getMinSecondaryCamera()).matches()) {
			filter.setMinSecondaryCameraValue(new BigDecimal(filter
					.getMinSecondaryCamera().replace(',', '.')));
		}
		if (PATTERN.matcher(filter.getMaxSecondaryCamera()).matches()) {
			filter.setMaxSecondaryCameraValue(new BigDecimal(filter
					.getMaxSecondaryCamera().replace(',', '.')));
		}
		if (PATTERN.matcher(filter.getMinRam()).matches()) {
			filter.setMinRamValue(new BigDecimal(filter.getMinRam().replace(
					',', '.')));
		}
		if (PATTERN.matcher(filter.getMaxRam()).matches()) {
			filter.setMaxRamValue(new BigDecimal(filter.getMaxRam().replace(
					',', '.')));
		}
		if (PATTERN.matcher(filter.getMinInternal()).matches()) {
			filter.setMinInternalValue(new BigDecimal(filter.getMinInternal()
					.replace(',', '.')));
		}
		if (PATTERN.matcher(filter.getMaxInternal()).matches()) {
			filter.setMaxInternalValue(new BigDecimal(filter.getMaxInternal()
					.replace(',', '.')));
		}
		if (PATTERN.matcher(filter.getMinCard()).matches()) {
			filter.setMinCardValue(new BigDecimal(filter.getMinCard().replace(
					',', '.')));
		}
		if (PATTERN.matcher(filter.getMaxCard()).matches()) {
			filter.setMaxCardValue(new BigDecimal(filter.getMaxCard().replace(
					',', '.')));
		}
		if (PATTERN1.matcher(filter.getNumberOfSimCardsFilter()).matches()) {
			filter.setNumberOfSimCardsValue(Integer.valueOf(filter
					.getNumberOfSimCardsFilter()));
		}
		if (PATTERN1.matcher(filter.getMinBattery()).matches()) {
			filter.setMinBatteryValue(new BigDecimal(filter.getMinBattery()
					.replace(',', '.')));
		}
		if (PATTERN1.matcher(filter.getMaxBattery()).matches()) {
			filter.setMaxBatteryValue(new BigDecimal(filter.getMaxBattery()
					.replace(',', '.')));
		}
	}

	private void filterByPhone(Root<Phone> root, CriteriaQuery<?> query,
			CriteriaBuilder cb) {
		if (!filter.getMakerIds().isEmpty()) {
			predicates.add(root.get("maker").in(filter.getMakerIds()));
		}
		if (!filter.getModelFilter().isEmpty()) {
			predicates.add(cb.like(cb.lower(root.get("model")), filter
					.getModelFilter().toLowerCase() + "%"));
		}
		if (filter.getMinPriceValue() != null) {
			predicates.add(cb.ge(root.get("price"), filter.getMinPriceValue()));
		}
		if (filter.getMaxPriceValue() != null) {
			predicates.add(cb.le(root.get("price"), filter.getMaxPriceValue()));
		}
		if (filter.getMinDisplayValueV() != null) {
			predicates.add(cb.ge(root.get("displayValue"),
					filter.getMinDisplayValueV()));
		}
		if (filter.getMaxDisplayValueV() != null) {
			predicates.add(cb.le(root.get("displayValue"),
					filter.getMaxDisplayValueV()));
		}
		if (!filter.getDisplayResolutionIds().isEmpty()) {
			predicates.add(root.get("displayResolution").in(
					filter.getDisplayResolutionIds()));
		}
		if (filter.getMinPrimaryCameraValue() != null) {
			predicates.add(cb.ge(root.get("primaryCamera"),
					filter.getMinPrimaryCameraValue()));
		}
		if (filter.getMaxPrimaryCameraValue() != null) {
			predicates.add(cb.le(root.get("primaryCamera"),
					filter.getMaxPrimaryCameraValue()));
		}
		if (filter.getMinSecondaryCameraValue() != null) {
			predicates.add(cb.ge(root.get("secondaryCamera"),
					filter.getMinSecondaryCameraValue()));
		}
		if (filter.getMaxSecondaryCameraValue() != null) {
			predicates.add(cb.le(root.get("secondaryCamera"),
					filter.getMaxSecondaryCameraValue()));
		}
		if (!filter.getProcessorIds().isEmpty()) {
			predicates.add(root.get("processor").in(filter.getProcessorIds()));
		}
		if (filter.getMinRamValue() != null) {
			predicates.add(cb.ge(root.get("ram"), filter.getMinRamValue()));
		}
		if (filter.getMaxRamValue() != null) {
			predicates.add(cb.le(root.get("ram"), filter.getMaxRamValue()));
		}
		if (filter.getMinInternalValue() != null) {
			predicates.add(cb.ge(root.get("internal"),
					filter.getMinInternalValue()));
		}
		if (filter.getMaxInternalValue() != null) {
			predicates.add(cb.le(root.get("internal"),
					filter.getMaxInternalValue()));
		}
		if (filter.getMinCardValue() != null) {
			predicates.add(cb.ge(root.get("card"), filter.getMinCardValue()));
		}
		if (filter.getMaxCardValue() != null) {
			predicates.add(cb.le(root.get("card"), filter.getMaxCardValue()));
		}
		if (filter.getNumberOfSimCardsValue() != null) {
			predicates.add(cb.equal(root.get("numberOfSimCards"),
					filter.getNumberOfSimCardsValue()));
		}
		if (!filter.getOperatingSystemIds().isEmpty()) {
			predicates.add(root.get("operatingSystem").in(
					filter.getOperatingSystemIds()));
		}
		if (filter.getMinBatteryValue() != null) {
			predicates.add(cb.ge(root.get("battery"),
					filter.getMinBatteryValue()));
		}
		if (filter.getMaxBatteryValue() != null) {
			predicates.add(cb.le(root.get("battery"),
					filter.getMaxBatteryValue()));
		}
		if (!filter.getColorIds().isEmpty()) {
			predicates.add(root.get("color").in(filter.getColorIds()));
		}
	}

	@Override
	public Predicate toPredicate(Root<Phone> root, CriteriaQuery<?> query,
			CriteriaBuilder cb) {
		filterByPhone(root, query, cb);
		if (predicates.isEmpty())
			return null;
		Predicate[] arr = new Predicate[predicates.size()];
		arr = predicates.toArray(arr);
		return cb.and(arr);
	}

}
